

public class WeChatHelper {
    public static String WECHAT_LOGIN = "WECHAT_LOGIN";
    public static String WECHAT_LOGIN_AUTH_KEY = "snsapi_userinfo";
    public static String WECHAT_LOGIN_IDENTIFIER = "AIRBNB";
    public static String WECHAT_SHARE = "WECHAT_SHARE";

    public static void loginWithWeChat(Context context) {
        String wechatAppID = getWeChatID(context);
        IWXAPI wechatAPI = WXAPIFactory.createWXAPI(context, wechatAppID, true);
        wechatAPI.registerApp(wechatAppID);
        Req req = new Req();
        req.scope = WECHAT_LOGIN_AUTH_KEY;
        req.state = WECHAT_LOGIN_IDENTIFIER;
        req.transaction = WECHAT_LOGIN;
        wechatAPI.sendReq(req);
    }

    public static String getWeChatID(Context context) {
        if (BuildHelper.isDevelopmentBuild()) {
            return context.getString(R.string.wechat_weixin_app_dev_id);
        }
        return context.getString(R.string.wechat_weixin_app_id);
    }

    public static void shareToWechat(Context context, String title, String description, String url, Bitmap thumbnail) {
        IWXAPI wechatAPI = WXAPIFactory.createWXAPI(context, getWeChatID(context), true);
        WXMediaMessage msg = new WXMediaMessage(new WXWebpageObject(url));
        msg.title = title;
        msg.description = description;
        msg.setThumbImage(thumbnail);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.message = msg;
        req.transaction = WECHAT_SHARE;
        wechatAPI.sendReq(req);
    }
}


