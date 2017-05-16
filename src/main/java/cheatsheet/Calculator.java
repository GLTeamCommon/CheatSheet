package cheatsheet;

import cheatsheet.expression_parser.ExpressionParser;
import cheatsheet.javaluator_extension.ExtendedEvaluator;
import com.fathzer.soft.javaluator.StaticVariableSet;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashMap;

import net.sourceforge.jwbf.mediawiki.bots.MediaWikiBot;
import info.bliki.wiki.model.WikiModel;
import net.sourceforge.jwbf.core.contentRep.Article;

import java.io.PrintWriter;

import net.sourceforge.jwbf.core.actions.HttpActionClient;

import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Calculator {
	private static final String DECIMAL_ROUND_OF_FORMAT = "0.00000000000000";
	private static final int[] PLOT_BUILD_BOUNDS = new int[]{-100, 100};
	private static final double PLOT_BUILD_STEP = 0.1;
	private final HashMap<Double, Double> coords = new HashMap<>();
	private Double evaluateResult;

    private int isAnswerExist = 0;
    private int isNameOfNumberExist = 0;
    private int isGraphicExist = 0;

	public String processExpression(final String expression) throws IllegalArgumentException,
			NullPointerException, ParseException {
		ExpressionParser parser = new ExpressionParser(expression);
		switch(parser.chooseType()) {
			case ARITHMETIC_EXPRESSION:
				evaluate(expression);
                this.isAnswerExist = 1;
                this.isNameOfNumberExist = 0;
                this.isGraphicExist = 1;
				return (this.evaluateResult.toString());
			case TWO_VAR_FUNCTION:
                this.isGraphicExist = 1;
				buildPlot(expression);
				return (this.coords.keySet().toString()
						.concat("$")
						.concat(coords.values().toString())
						.replaceAll(" ", "")
						.replace("[", "")
						.replace("]", ""));
			case TEXT:
                this.isAnswerExist = 1;
                System.out.println("try to get Wiki");
				return getWiki(expression);
			default:
				return "Unsupported input";
		}
	}

	private void buildPlot(String expression) throws IllegalArgumentException,
			NullPointerException, ParseException {
		final ExtendedEvaluator eval = new ExtendedEvaluator();
		final StaticVariableSet<Double> variables = new StaticVariableSet<Double>();
		String variable;
		if (expression.split("=")[1].toLowerCase().contains("x")) {
			variable = "x";
		} else if (expression.split("=")[1].toLowerCase().contains("y")){
			variable = "y";
		} else {
			variable = "z";
		}
		for (double step = PLOT_BUILD_BOUNDS[0]; step < PLOT_BUILD_BOUNDS[1];
			 	step += PLOT_BUILD_STEP) {
			variables.set(variable, step);
			Double result = eval.evaluate(expression.split("=")[1], variables);
			this.coords.put(step, result);
		}
	}

	private void evaluate(String expression)
			throws IllegalArgumentException, NullPointerException, ParseException {
		ExtendedEvaluator evaluator = new ExtendedEvaluator();

		DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_ROUND_OF_FORMAT);
		String format = decimalFormat.format(evaluator.evaluate(expression));
		this.evaluateResult = this.convertDouble(decimalFormat.parse(format));
	}

	private double convertDouble(Object longValue) throws IllegalArgumentException {
		double valueTwo;

		if(longValue instanceof Long) {
			valueTwo = ((Long) longValue).doubleValue();
		} else if (longValue instanceof Double){
			valueTwo = (Double)longValue;
		} else {
			throw new IllegalArgumentException();
		}

		return valueTwo;
	}

    private String getWiki(String findRequest) {
        MediaWikiBot wikiBot = new MediaWikiBot("http://en.wikipedia.org/w/");
        Article article = wikiBot.getArticle(findRequest);
        wikiBot.login("evgenyzhurko", "evgenyzhurko123");
        article.save();
        try{
            WikiModel wikiModel = new WikiModel("${image}", "${title}");
            String html = wikiModel.render(article.getText());
            
            Document doc = Jsoup.parse(html);
            for(Element e: doc.select("a"))
                e.remove();
            for(Element e: doc.select("table.toc"))
                e.remove();
            for(Element e: doc.select("ul"))
                e.remove();
            
            doc.getElementById("See_also").remove();
            doc.getElementById("References").remove();
            doc.getElementById("External_links").remove();
            
            System.out.println("Fuck" + html);

            html = doc.select("body").toString();
            
            return html;
        } catch (IOException e) {
            System.out.println("Pized na wiki");
            return "Something went wrong...";
        }
    }

    public int getIsAnswerExist() {
        return this.isAnswerExist;
    }

    public int getIsNameOfNumberExist() {
        return this.isNameOfNumberExist;
    }

    public int getGraphicExist() {
        return this.isGraphicExist;
    }
}
