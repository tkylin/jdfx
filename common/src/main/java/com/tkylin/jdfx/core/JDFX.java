package com.tkylin.jdfx.core;

import com.jfinal.kit.PropKit;
import com.tkylin.jdfx.core.dto.JdfxConfig;

/**
 * Created by tkyli on 2017/3/8.
 */
public class JDFX {
    private static JdfxConfig config;

    static {
        PropKit.use("jdfx.properties", "utf-8");
        config = new JdfxConfig();
        config.setFxApi(PropKit.get("fx.api", ""));
        config.setFxIndex(PropKit.get("fx.index", ""));
        config.setFxHhApi(PropKit.get("fx.hh.api", ""));
        config.setFxHhIndex(PropKit.get("fx.hh.index", ""));
        config.setImageSavePath(PropKit.get("image.save.path",""));
        config.setTimeoutMillis(PropKit.getLong("timeout.millis",60000L));
    }


}
