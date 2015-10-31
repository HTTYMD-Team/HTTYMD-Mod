package com.httymd.client.animation;

import net.minecraft.client.model.ModelRenderer;

import com.httymd.client.model.ModelDragonNew;
import com.httymd.externals.org.apache.commons.math3.PolynomialSplineFunction;
import com.httymd.externals.org.apache.commons.math3.SplineInterpolator;

public class Animation {
	private final ModelRenderer[] componentIDs;
	private final PolynomialSplineFunction[][] psfs;

	protected final int duration;
	private final int frames;

	/**
	 * 
	 * @param components2
	 * @param data
	 *            [component][attributeId][frame]
	 * 
	 *            attributeIDs: 0: rotationPointX 1: rotationPointY 2:
	 *            rotationPointZ 3: rotationX 4: rotationY 5: rotationZ
	 */
	public Animation(ModelRenderer[] components2, float[][][] data, int duration) {
		this.componentIDs = components2;
		this.duration = duration;

		int components = data.length;
		frames = data[0][0].length;

		psfs = new PolynomialSplineFunction[components2.length][6];

		SplineInterpolator si = new SplineInterpolator();

		double[] xArr = new double[frames + 5];
		for (int i = 0; i < frames + 5; i++)
			xArr[i] = i - 2;

		for (int component = 0; component < components; component++) {
			double[][] yArr = new double[6][frames + 5];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < frames + 5; j++)
					yArr[i][j] = data[component][i][(j + frames - 2) % frames];

				psfs[component][i] = si.interpolate(xArr, yArr[i]);
			}
		}
		//
		// for (double d = -2; d < 4; d += 0.01)
		// System.out.println(psfs[0][1].value(d));
		// if (1 + 1 == 2)
		// System.exit(0);
	}

	protected void animate(ModelDragonNew dragon, long millis) {
		// TODO this calculation only works with loops
		float step = (float) millis % duration / duration * frames;
		for (int componentId = 0; componentId < componentIDs.length; componentId++) {
			ModelRenderer component = componentIDs[componentId];

			component.rotationPointX = getValue(componentId, 0, step);
			component.rotationPointY = getValue(componentId, 1, step);
			component.rotationPointZ = getValue(componentId, 2, step);

			component.rotateAngleX = (float) (getValue(componentId, 3, step) / 180 * Math.PI);
			component.rotateAngleY = (float) (getValue(componentId, 4, step) / 180 * Math.PI);
			component.rotateAngleZ = (float) (getValue(componentId, 5, step) / 180 * Math.PI);
		}
	}

	private float getValue(int component, int attribute, double time) {
		return (float) psfs[component][attribute].value(time);
	}
}
