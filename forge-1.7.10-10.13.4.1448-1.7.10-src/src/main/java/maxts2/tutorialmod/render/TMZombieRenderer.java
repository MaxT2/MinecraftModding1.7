package maxts2.tutorialmod.render;

import org.lwjgl.opengl.GL11;

import maxts2.tutorialmod.ATutorialMod;
import maxts2.tutorialmod.entities.TMZombieEntity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class TMZombieRenderer extends RenderLiving {

	    protected ResourceLocation TZombieTexture;

	    public TMZombieRenderer(ModelBase par1ModelBase, float parShadowSize)
	    {
	        super(par1ModelBase, parShadowSize);
	        setEntityTexture();
	    }

	    @Override
	    protected void preRenderCallback(EntityLivingBase entity, float f)
	    {
	        preRenderCallback((TMZombieEntity) entity, f);
	    }

	    protected void preRenderCallback(TMZombieEntity entity, float f)
	    {
	        // some people do some G11 transformations or blends here, like you can do
	        // GL11.glScalef(2F, 2F, 2F); to scale up the entity
	        // which is used for Slime entities.  I suggest having the entity cast to
	        // your custom type to make it easier to access fields from your
	        // custom entity, eg. GL11.glScalef(entity.scaleFactor, entity.scaleFactor,
	        // entity.scaleFactor);
	    	//GL11.glScalef(.2f, .3f, .3f);
	    }

	    protected void setEntityTexture()
	    {
	        TZombieTexture = new ResourceLocation(ATutorialMod.MODID+":textures/entity/zombie/zombie.png");
//	        TZombieTexture = new ResourceLocation("textures/entity/villager/butcher.png");
	    }

	    /**
	    * Returns the location of an entity's texture. Doesn't seem to be called
	    * unless you call Render.bindEntityTexture.
	    */
	    @Override
	    protected ResourceLocation getEntityTexture(Entity par1Entity)
	    {
	        return TZombieTexture;
	    }
	}
