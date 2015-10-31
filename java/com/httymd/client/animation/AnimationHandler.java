package com.httymd.client.animation;

import com.httymd.client.model.ModelDragonNew;

public class AnimationHandler {
	private final ModelDragonNew dragon;

	private Animation currentAnimation;
	private long currentStart;
	private boolean currentIsLoop;

	private Animation nextAnimation;
	private Priority nextPriority = Priority.WAIT_FOR_ANIM_TO_FINISH;
	private boolean nextIsLoop;

	public enum Priority {
		START_INSTANTLY, WAIT_FOR_ANIM_TO_FINISH
	};

	public AnimationHandler(ModelDragonNew dragon) {
		this.dragon = dragon;
	}

	public boolean isHeadDisabled() {
		return false;
		// TODO
		// return currentAnimation.isHeadDisabled();
	}

	public boolean isWalkingDisabled() {
		return false;
		// TODO
		// return currentAnimation.isWalkingDisabled();
	}

	public void animate() {
		if (nextAnimation != null && (nextPriority == Priority.START_INSTANTLY || currentAnimation == null))
			switchAnimation();

		if (currentAnimation != null) {
			long time = System.currentTimeMillis();
			long currentStep = (time - currentStart);

			if (currentStep > currentAnimation.duration && (!currentIsLoop || nextAnimation != null || nextPriority == Priority.WAIT_FOR_ANIM_TO_FINISH))
				switchAnimation();

			currentAnimation.animate(dragon, currentStep);
		}
	}

	public void addAnimation(Animation animation, Priority priority, boolean isLoop) {
		nextAnimation = animation;
		nextPriority = priority;
		nextIsLoop = isLoop;
	}

	private void switchAnimation() {
		// if (nextAnimation == null) {
		// // TODO
		// // currentAnimation = dragon.getAnimation("idle");
		// // currentStart = System.currentTimeMillis();
		// // currentIsLoop = true;
		// } else {
		currentAnimation = nextAnimation;
		currentStart = System.currentTimeMillis();
		currentIsLoop = nextIsLoop;
		nextAnimation = null;
		nextPriority = null;
		// }
	}
}
