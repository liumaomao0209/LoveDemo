package com.example.technology.lovedemo;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * 估值器
 * */
public class BasEvaluator implements TypeEvaluator<PointF> {
 
	private PointF p1;
	private PointF p2;
 
	public BasEvaluator(PointF p1, PointF p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}
 
	@Override
	public PointF evaluate(float fraction, PointF p0, PointF p3) {
		// TODO Auto-generated method stub
		PointF pointf = new PointF();
		
		// 贝塞尔曲线公式  p0*(1-t)^3 + 3p1*t*(1-t)^2 + 3p2*t^2*(1-t) + p3^3
		pointf.x = p0.x * (1-fraction) *(1-fraction ) * (1-fraction)
				   +3*p1.x * fraction *(1-fraction )*(1-fraction )
				   +3*p2.x *fraction  *fraction  *(1-fraction )
				   +p3.x*fraction *fraction *fraction ; 
		pointf.y = p0.y * (1-fraction ) *(1-fraction ) * (1-fraction )
				+3*p1.y * fraction *(1-fraction )*(1-fraction )
				+3*p2.y *fraction  *fraction  *(1-fraction )
				+p3.y*fraction *fraction *fraction ; 
		return pointf;
	}
}