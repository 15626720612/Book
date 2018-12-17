	jQuery(function($){
		$('#banner_pic').slideBox({  //左右轮播，滚动持续0.3秒，滚动延迟5秒，滚动效果linear，初始焦点第1张，点选按键不隐藏，按键边框半径10px（圆形）
			duration : 0.3,//滚动持续时间，单位：秒
			easing : 'linear',//swing,linear//滚动特效
			delay : 5,//滚动延迟时间，单位：秒
			hideClickBar : false,//不自动隐藏点选按键
			clickBarRadius : 10  //按键边框半径10px（圆形）
		});
	});