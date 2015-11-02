package com.httymd.entity;

import net.minecraft.util.DamageSource;

public interface IInjurable {

	public class Injury {

		private String name;
		private int damage;
		private DamageSource source;

		public Injury(int baseDamage, DamageSource source) {
			this("", baseDamage, source);

			char[] cArr = source.getDamageType().toCharArray();
			cArr[0] = Character.toUpperCase(cArr[0]);

			this.name = String.copyValueOf(cArr);
		}

		public Injury(String name, DamageSource source) {
			this(name, 1, source);
		}

		public Injury(String name, int baseDamage, DamageSource source) {
			this(name, baseDamage, 1, source);
		}

		public Injury(String name, int baseDamage, int damageMultipler, DamageSource source) {
			this.name = name;
			this.damage = baseDamage * damageMultipler;
			this.source = source;
		}

		public String getName() {
			return this.name;
		}

		public int getDamage() {
			return this.damage;
		}

		public DamageSource getSource() {
			return this.source;
		}
	}

	public Injury[] getInjurys();

	public void onInjury(Injury injury);
}
