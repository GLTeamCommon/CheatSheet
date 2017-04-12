/**
* движок мульта на основе изображения img
* необходимо подключить scriptjava
* http://scriptjava.net/source/scriptjava/scriptjava.js
*/
var cartoon_image = function () {
	return {
	key:true,
	number_x:'',
	number_y:'',
	frame_x:'',
	frame_y:'',
	frames_x:'',
	frames_y:'',
	id:'',
	speed:'',
	reverse:'',
	playandstop:'',
	next:'',
	timer:'',
	play: function (param) {
		param = param || {};
		var default_param = {
			id:['block','cartoon'],//id div элемента и img элемента
			src:'test_img/test.png',//ссылка на изображение
			frames_x:60,//количество кадров на изображении по x
			frames_y:1,//количество кадров на изображении по y
			width:12120,//ширина изображения
			height:193,//высота изображения
			fps:24,//скорость показа кадров в секунду, можно писать дробные числа
			reverse:false,//если true то проигрывается с конца в начало
			playandstop:false,//если true то проиграть 1 раз и передать управление функции next
			next: function () {//выполнится только если playandstop==true
				//сюда можно пысать следующий код который будет выполняться после завершения анимации
			}
		}
		for(var index in default_param) {
			if(typeof param[index] == "undefined") param[index] = default_param[index];
		}
		
		
		this.key=true;
		this.number_x=1;
		this.number_y=1;
		this.frame_x=Math.round(param['width']/param['frames_x']);
		this.frame_y=Math.round(param['height']/param['frames_y']);
		this.frames_x=param['frames_x'];
		this.frames_y=param['frames_y'];
		this.id=param['id'][1];
		this.speed=Math.round(1000/param['fps']);
		this.reverse=param['reverse'];
		this.playandstop=param['playandstop'];
		this.next=param['next'];
		
		$$(param['id'][0]).$$('width',this.frame_x+'px').$$('height',this.frame_y+'px').$$('overflow','hidden');
		
		$$(this.id)['src']=param['src'];
		var left=(this.frames_x-1)*this.frame_x;
		var top=(this.frames_y-1)*this.frame_y;
		(this.reverse)?$$(this.id).$$('marginLeft',''+-left+'px').$$('marginTop',''+-top+'px'):$$(this.id).$$('marginLeft','0px').$$('marginTop','0px');
		var th = this;
		this.timer=setTimeout(function () { th.show(); },this.speed);
	},
	show: function () {
		this.number_x++;
		if(this.number_x-1>=this.frames_x) {
			this.number_x=1;
			this.number_y++;
			if(this.number_y-1>=this.frames_y) {
				this.number_y=1;
				if(this.playandstop) {
					this.stop();
				}
			}
		}
		if(this.key) {
			var left;
			var top;
			(this.reverse)?left=(this.frames_x-this.number_x)*this.frame_x:left=(this.number_x-1)*this.frame_x;
			(this.reverse)?top=(this.frames_y-this.number_y)*this.frame_y:top=(this.number_y-1)*this.frame_y;
			$$(this.id).$$('marginLeft',''+-left+'px').$$('marginTop',''+-top+'px');
			var th = this;
			this.timer=setTimeout(function () { th.show(); },this.speed);
		}
		else {
			this.next();
		}
	},
	stop: function () {
		this.key=false;
		if(this.timer) {
			clearTimeout(this.timer);
		}
	},
	getframe: function (fx,fy) {
		var left=(fx-1)*this.frame_x;
		var top=(fy-1)*this.frame_y;
		$$(this.id).$$('marginLeft',''+-left+'px').$$('marginTop',''+-top+'px');
	}
	}
}
