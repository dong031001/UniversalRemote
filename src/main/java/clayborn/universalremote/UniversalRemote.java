package clayborn.universalremote;

import clayborn.universalremote.proxy.ISidedProxy;
import clayborn.universalremote.registrar.Registrar;
import clayborn.universalremote.settings.Strings;
import clayborn.universalremote.util.Util;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Strings.MODID, version = Strings.VERSION)
public class UniversalRemote
{

	// Proxy
    @SidedProxy(clientSide = Strings.CLIENTPROXY, serverSide = Strings.SERVERPROXY)
    public static ISidedProxy proxy;    
    
    // Here be initialization events!
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	Util.logger = event.getModLog();

    	MinecraftForge.EVENT_BUS.register(new Registrar());
    	
    	proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event){
    	proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	proxy.postInit(event);

    }    
    
}
