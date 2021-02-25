package com.imooc.template;

public class RoomForChineseSinger extends KTVRoom{
	@Override
	protected void orderSong() {
		System.out.println("来一首劲爆的歌曲");
	}

	@Override
	//钩子函数可以选择性实现
	protected void orderExtra(){
		System.out.println("东西真便宜，以来一份");
	}
}
