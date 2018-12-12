package com.github.testarea.githubWiki.rendering.JOGL_alone_Test;

import com.github.physiengine.components.Component;

public class MyImageComponent extends Component{

	public ImageResource img;
	
	public MyImageComponent(String path) {
		img = new ImageResource(path);
	}
	
	@Override
	public void update() {
		
	}

}
