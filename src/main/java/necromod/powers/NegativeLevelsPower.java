package necromod.powers;

import com.megacrit.cardcrawl.dungeons.*;
import com.megacrit.cardcrawl.core.*;
import com.megacrit.cardcrawl.powers.*;
import com.megacrit.cardcrawl.actions.common.*;

import necromod.NecroMod;

public class NegativeLevelsPower extends AbstractPower {
	public static final String POWER_ID = "Negative_Level";
	public static final String NAME = "Negative Level";
	public static final String[] DESCRIPTIONS = new String[] {
			"Adds -!M! Strength. NL Adds -!M! Dexterity."
	};
	
	
    
    public NegativeLevelsPower(final AbstractCreature owner, final AbstractCreature source, final int nLevelAmt) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = nLevelAmt;
        this.updateDescription();
        this.type = PowerType.DEBUFF;
        this.isTurnBased = false;
        this.img = NecroMod.getNegativeLevelTexture();
        
    }
    
    @Override
    public void updateDescription() {
    	this.description = DESCRIPTIONS[0] + this.amount;
    }
    
    
    @Override
    public void atEndOfTurn(final boolean isPlayer) {
    	
    	this.amount = (int) (this.amount/2);
        this.flash();
        
        
    	
        if(this.amount <1) {
        	AbstractDungeon.actionManager.addToTop(new RemoveSpecificPowerAction(this.owner, this.owner, "Negative_Level"));
        	AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(this.owner, this.owner, new StrengthPower(this.owner, 1), 1));
        }
        else {
        	AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(this.owner, this.owner, new StrengthPower(this.owner, this.amount), this.amount));
        }    	

    }

}
