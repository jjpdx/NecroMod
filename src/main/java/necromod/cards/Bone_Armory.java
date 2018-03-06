package necromod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.abstracts.CustomCard;
import necromod.NecroMod;
import necromod.patches.AbstractCardEnum;

import necromod.powers.BoneArmoryPower;

public class Bone_Armory extends CustomCard {
	
	public static final String ID = "Bone_Armory";
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	public static final	String NAME = cardStrings.NAME;
	public static final	String DESCRIPTION = cardStrings.DESCRIPTION;
	private static final int COST = 1;
	private static final int POOL = 1;
	private final int AMOUNT = 1;
	private static final int UPGRADE_AMOUNT = 1;
	
	public Bone_Armory() {
		super(ID, NAME, NecroMod.makePath(NecroMod.BONE_ARMORY), COST, DESCRIPTION, AbstractCard.CardType.POWER,
				AbstractCardEnum.WHITE, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.SELF, POOL);
		
		this.baseMagicNumber = this.magicNumber = AMOUNT;
		
		
	}
	
	public void use(AbstractPlayer p, AbstractMonster m) {
		
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new BoneArmoryPower(p, this.AMOUNT), this.AMOUNT));
	}
	
	public AbstractCard makeCopy() {
		return new Bone_Armory();
	}
	
	public void upgrade() {
		if (!this.upgraded) {
			this.upgradeName();
			this.upgradeMagicNumber(UPGRADE_AMOUNT);
		}
	}
	

}
