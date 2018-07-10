package com.soul.androidguide.bean;

/**
 * Created by Soul on 2018/6/19.
 */

public class InformationData {


    /**
     * code : 0
     * message : 0
     * data : {"todo":{"sign":{"days":1,"vcoin":"20V","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"},"weather":{"weather":"25/30°C","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"},"order":{"hint":"未完成订单","hintNum":6,"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"},"member":{"hint":"会员即将到期","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"},"coupon":{"num":2,"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"}},"recommendation":{"exclusive":{"title":"《冰雪奇缘》","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"},"subscribe":{"title":"《冰雪奇缘》","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"}},"visible":{"recommend":{"title":"《冰雪奇缘》","hintText":"电影","who":"小伟","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","headUrl":"url"},"shareVideo":{"who":"小伟","hintNum":7,"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","headUrl":"url"},"shareImg":{"who":"小伟","hintNum":7,"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","headUrl":"url"},"call":{"who":"小伟","hintNum":7,"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","hintBackground":"ImgUrl or ImgType"}},"smart":{"face":{"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","hintBackground":"ImgUrl or ImgType"},"voiceprint":{"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","hintBackground":"ImgUrl or ImgType"},"voice":{"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","hintBackground":"ImgUrl or ImgType"}}}
     */

    private int code;
    private int message;
    private DataBean data;


    @Override
    public String toString() {
        return "InformationData{" +
                "code=" + code +
                ", message=" + message +
                ", data=\n" + data.toString() +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * todo : {"sign":{"days":1,"vcoin":"20V","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"},"weather":{"weather":"25/30°C","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"},"order":{"hint":"未完成订单","hintNum":6,"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"},"member":{"hint":"会员即将到期","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"},"coupon":{"num":2,"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"}}
         * recommendation : {"exclusive":{"title":"《冰雪奇缘》","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"},"subscribe":{"title":"《冰雪奇缘》","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"}}
         * visible : {"recommend":{"title":"《冰雪奇缘》","hintText":"电影","who":"小伟","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","headUrl":"url"},"shareVideo":{"who":"小伟","hintNum":7,"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","headUrl":"url"},"shareImg":{"who":"小伟","hintNum":7,"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","headUrl":"url"},"call":{"who":"小伟","hintNum":7,"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","hintBackground":"ImgUrl or ImgType"}}
         * smart : {"face":{"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","hintBackground":"ImgUrl or ImgType"},"voiceprint":{"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","hintBackground":"ImgUrl or ImgType"},"voice":{"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","hintBackground":"ImgUrl or ImgType"}}
         */

        private TodoBean todo;
        private RecommendationBean recommendation;
        private VisibleBean visible;
        private SmartBean smart;

        @Override
        public String toString() {
            return "DataBean{" +
                    "todo=" + todo.toString() +
                    ",\n recommendation=" + recommendation.toString() +
                    ",\n visible=" + visible.toString() +
                    ",\n smart=" + smart.toString() +
                    '}';
        }

        public TodoBean getTodo() {
            return todo;
        }

        public void setTodo(TodoBean todo) {
            this.todo = todo;
        }

        public RecommendationBean getRecommendation() {
            return recommendation;
        }

        public void setRecommendation(RecommendationBean recommendation) {
            this.recommendation = recommendation;
        }

        public VisibleBean getVisible() {
            return visible;
        }

        public void setVisible(VisibleBean visible) {
            this.visible = visible;
        }

        public SmartBean getSmart() {
            return smart;
        }

        public void setSmart(SmartBean smart) {
            this.smart = smart;
        }

        public static class TodoBean {
            /**
             * sign : {"days":1,"vcoin":"20V","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"}
             * weather : {"weather":"25/30°C","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"}
             * order : {"hint":"未完成订单","hintNum":6,"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"}
             * member : {"hint":"会员即将到期","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"}
             * coupon : {"num":2,"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"}
             */

            private SignBean sign;
            private WeatherBean weather;
            private OrderBean order;
            private MemberBean member;
            private CouponBean coupon;

            @Override
            public String toString() {
                return "TodoBean{" +
                        "sign=" + sign.toString() +
                        ", weather=" + weather.toString() +
                        ", order=" + order.toString() +
                        ", member=" + member.toString() +
                        ", coupon=" + coupon.toString() +
                        '}';
            }

            public SignBean getSign() {
                return sign;
            }

            public void setSign(SignBean sign) {
                this.sign = sign;
            }

            public WeatherBean getWeather() {
                return weather;
            }

            public void setWeather(WeatherBean weather) {
                this.weather = weather;
            }

            public OrderBean getOrder() {
                return order;
            }

            public void setOrder(OrderBean order) {
                this.order = order;
            }

            public MemberBean getMember() {
                return member;
            }

            public void setMember(MemberBean member) {
                this.member = member;
            }

            public CouponBean getCoupon() {
                return coupon;
            }

            public void setCoupon(CouponBean coupon) {
                this.coupon = coupon;
            }

            public static class SignBean {
                /**
                 * days : 1
                 * vcoin : 20V
                 * actionType : 1
                 * actionUrl : xxxx
                 * className : className
                 * pkgName : pkgName
                 * background : ImgUrl or ImgType
                 */

                private int days;
                private String vcoin;
                private int actionType;
                private String actionUrl;
                private String className;
                private String pkgName;
                private String background;


                @Override
                public String toString() {
                    return "SignBean{" +
                            "days=" + days +
                            ", vcoin='" + vcoin + '\'' +
                            ", actionType=" + actionType +
                            ", actionUrl='" + actionUrl + '\'' +
                            ", className='" + className + '\'' +
                            ", pkgName='" + pkgName + '\'' +
                            ", background='" + background + '\'' +
                            '}';
                }

                public int getDays() {
                    return days;
                }

                public void setDays(int days) {
                    this.days = days;
                }

                public String getVcoin() {
                    return vcoin;
                }

                public void setVcoin(String vcoin) {
                    this.vcoin = vcoin;
                }

                public int getActionType() {
                    return actionType;
                }

                public void setActionType(int actionType) {
                    this.actionType = actionType;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public String getClassName() {
                    return className;
                }

                public void setClassName(String className) {
                    this.className = className;
                }

                public String getPkgName() {
                    return pkgName;
                }

                public void setPkgName(String pkgName) {
                    this.pkgName = pkgName;
                }

                public String getBackground() {
                    return background;
                }

                public void setBackground(String background) {
                    this.background = background;
                }
            }

            public static class WeatherBean {
                /**
                 * weather : 25/30°C
                 * actionType : 1
                 * actionUrl : xxxx
                 * className : className
                 * pkgName : pkgName
                 * background : ImgUrl or ImgType
                 */

                private String weather;
                private int actionType;
                private String actionUrl;
                private String className;
                private String pkgName;
                private String background;

                @Override
                public String toString() {
                    return "WeatherBean{" +
                            "weather='" + weather + '\'' +
                            ", actionType=" + actionType +
                            ", actionUrl='" + actionUrl + '\'' +
                            ", className='" + className + '\'' +
                            ", pkgName='" + pkgName + '\'' +
                            ", background='" + background + '\'' +
                            '}';
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public int getActionType() {
                    return actionType;
                }

                public void setActionType(int actionType) {
                    this.actionType = actionType;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public String getClassName() {
                    return className;
                }

                public void setClassName(String className) {
                    this.className = className;
                }

                public String getPkgName() {
                    return pkgName;
                }

                public void setPkgName(String pkgName) {
                    this.pkgName = pkgName;
                }

                public String getBackground() {
                    return background;
                }

                public void setBackground(String background) {
                    this.background = background;
                }
            }

            public static class OrderBean {
                /**
                 * hint : 未完成订单
                 * hintNum : 6
                 * actionType : 1
                 * actionUrl : xxxx
                 * className : className
                 * pkgName : pkgName
                 * background : ImgUrl or ImgType
                 */

                private String hint;
                private int hintNum;
                private int actionType;
                private String actionUrl;
                private String className;
                private String pkgName;
                private String background;


                @Override
                public String toString() {
                    return "OrderBean{" +
                            "hint='" + hint + '\'' +
                            ", hintNum=" + hintNum +
                            ", actionType=" + actionType +
                            ", actionUrl='" + actionUrl + '\'' +
                            ", className='" + className + '\'' +
                            ", pkgName='" + pkgName + '\'' +
                            ", background='" + background + '\'' +
                            '}';
                }

                public String getHint() {
                    return hint;
                }

                public void setHint(String hint) {
                    this.hint = hint;
                }

                public int getHintNum() {
                    return hintNum;
                }

                public void setHintNum(int hintNum) {
                    this.hintNum = hintNum;
                }

                public int getActionType() {
                    return actionType;
                }

                public void setActionType(int actionType) {
                    this.actionType = actionType;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public String getClassName() {
                    return className;
                }

                public void setClassName(String className) {
                    this.className = className;
                }

                public String getPkgName() {
                    return pkgName;
                }

                public void setPkgName(String pkgName) {
                    this.pkgName = pkgName;
                }

                public String getBackground() {
                    return background;
                }

                public void setBackground(String background) {
                    this.background = background;
                }
            }

            public static class MemberBean {
                /**
                 * hint : 会员即将到期
                 * actionType : 1
                 * actionUrl : xxxx
                 * className : className
                 * pkgName : pkgName
                 * background : ImgUrl or ImgType
                 */

                private String hint;
                private int actionType;
                private String actionUrl;
                private String className;
                private String pkgName;
                private String background;

                @Override
                public String toString() {
                    return "MemberBean{" +
                            "hint='" + hint + '\'' +
                            ", actionType=" + actionType +
                            ", actionUrl='" + actionUrl + '\'' +
                            ", className='" + className + '\'' +
                            ", pkgName='" + pkgName + '\'' +
                            ", background='" + background + '\'' +
                            '}';
                }

                public String getHint() {
                    return hint;
                }

                public void setHint(String hint) {
                    this.hint = hint;
                }

                public int getActionType() {
                    return actionType;
                }

                public void setActionType(int actionType) {
                    this.actionType = actionType;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public String getClassName() {
                    return className;
                }

                public void setClassName(String className) {
                    this.className = className;
                }

                public String getPkgName() {
                    return pkgName;
                }

                public void setPkgName(String pkgName) {
                    this.pkgName = pkgName;
                }

                public String getBackground() {
                    return background;
                }

                public void setBackground(String background) {
                    this.background = background;
                }
            }

            public static class CouponBean {
                /**
                 * num : 2
                 * actionType : 1
                 * actionUrl : xxxx
                 * className : className
                 * pkgName : pkgName
                 * background : ImgUrl or ImgType
                 */

                private int num;
                private int actionType;
                private String actionUrl;
                private String className;
                private String pkgName;
                private String background;

                @Override
                public String toString() {
                    return "CouponBean{" +
                            "num=" + num +
                            ", actionType=" + actionType +
                            ", actionUrl='" + actionUrl + '\'' +
                            ", className='" + className + '\'' +
                            ", pkgName='" + pkgName + '\'' +
                            ", background='" + background + '\'' +
                            '}';
                }

                public int getNum() {
                    return num;
                }

                public void setNum(int num) {
                    this.num = num;
                }

                public int getActionType() {
                    return actionType;
                }

                public void setActionType(int actionType) {
                    this.actionType = actionType;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public String getClassName() {
                    return className;
                }

                public void setClassName(String className) {
                    this.className = className;
                }

                public String getPkgName() {
                    return pkgName;
                }

                public void setPkgName(String pkgName) {
                    this.pkgName = pkgName;
                }

                public String getBackground() {
                    return background;
                }

                public void setBackground(String background) {
                    this.background = background;
                }
            }
        }

        public static class RecommendationBean {
            /**
             * exclusive : {"title":"《冰雪奇缘》","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"}
             * subscribe : {"title":"《冰雪奇缘》","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType"}
             */

            private ExclusiveBean exclusive;
            private SubscribeBean subscribe;

            public ExclusiveBean getExclusive() {
                return exclusive;
            }

            public void setExclusive(ExclusiveBean exclusive) {
                this.exclusive = exclusive;
            }

            public SubscribeBean getSubscribe() {
                return subscribe;
            }

            public void setSubscribe(SubscribeBean subscribe) {
                this.subscribe = subscribe;
            }

            public static class ExclusiveBean {
                /**
                 * title : 《冰雪奇缘》
                 * actionType : 1
                 * viewType : 0 big 1 normal
                 * actionUrl : xxxx
                 * className : className
                 * pkgName : pkgName
                 * background : ImgUrl or ImgType
                 */

                private String title;
                private int viewType;
                private int actionType;
                private String actionUrl;
                private String className;
                private String pkgName;
                private String background;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getActionType() {
                    return actionType;
                }

                public void setActionType(int actionType) {
                    this.actionType = actionType;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public String getClassName() {
                    return className;
                }

                public void setClassName(String className) {
                    this.className = className;
                }

                public String getPkgName() {
                    return pkgName;
                }

                public void setPkgName(String pkgName) {
                    this.pkgName = pkgName;
                }

                public String getBackground() {
                    return background;
                }

                public int getViewType() {
                    return viewType;
                }

                public void setViewType(int viewType) {
                    this.viewType = viewType;
                }

                public void setBackground(String background) {
                    this.background = background;
                }
            }

            public static class SubscribeBean {
                /**
                 * title : 《冰雪奇缘》
                 * actionType : 1
                 * viewType : 0 big 1 normal
                 * actionUrl : xxxx
                 * className : className
                 * pkgName : pkgName
                 * background : ImgUrl or ImgType
                 */

                private String title;
                private int actionType;
                private int viewType ;
                private String actionUrl;
                private String className;
                private String pkgName;
                private String background;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getActionType() {
                    return actionType;
                }

                public void setActionType(int actionType) {
                    this.actionType = actionType;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public String getClassName() {
                    return className;
                }

                public void setClassName(String className) {
                    this.className = className;
                }

                public String getPkgName() {
                    return pkgName;
                }

                public void setPkgName(String pkgName) {
                    this.pkgName = pkgName;
                }

                public String getBackground() {
                    return background;
                }

                public int getViewType() {
                    return viewType;
                }

                public void setViewType(int viewType) {
                    this.viewType = viewType;
                }

                public void setBackground(String background) {
                    this.background = background;
                }
            }
        }

        public static class VisibleBean {
            /**
             * recommend : {"title":"《冰雪奇缘》","hintText":"电影","who":"小伟","actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","headUrl":"url"}
             * shareVideo : {"who":"小伟","hintNum":7,"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","headUrl":"url"}
             * shareImg : {"who":"小伟","hintNum":7,"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","headUrl":"url"}
             * call : {"who":"小伟","hintNum":7,"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","hintBackground":"ImgUrl or ImgType"}
             */

            private RecommendBean recommend;
            private ShareVideoBean shareVideo;
            private ShareImgBean shareImg;
            private CallBean call;

            public RecommendBean getRecommend() {
                return recommend;
            }

            public void setRecommend(RecommendBean recommend) {
                this.recommend = recommend;
            }

            public ShareVideoBean getShareVideo() {
                return shareVideo;
            }

            public void setShareVideo(ShareVideoBean shareVideo) {
                this.shareVideo = shareVideo;
            }

            public ShareImgBean getShareImg() {
                return shareImg;
            }

            public void setShareImg(ShareImgBean shareImg) {
                this.shareImg = shareImg;
            }

            public CallBean getCall() {
                return call;
            }

            public void setCall(CallBean call) {
                this.call = call;
            }

            public static class RecommendBean {
                /**
                 * title : 《冰雪奇缘》
                 * hintText : 电影
                 * who : 小伟
                 * actionType : 1
                 * actionUrl : xxxx
                 * className : className
                 * pkgName : pkgName
                 * background : ImgUrl or ImgType
                 * headUrl : url
                 */

                private String title;
                private String hintText;
                private String who;
                private int actionType;
                private String actionUrl;
                private String className;
                private String pkgName;
                private String background;
                private String headUrl;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getHintText() {
                    return hintText;
                }

                public void setHintText(String hintText) {
                    this.hintText = hintText;
                }

                public String getWho() {
                    return who;
                }

                public void setWho(String who) {
                    this.who = who;
                }

                public int getActionType() {
                    return actionType;
                }

                public void setActionType(int actionType) {
                    this.actionType = actionType;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public String getClassName() {
                    return className;
                }

                public void setClassName(String className) {
                    this.className = className;
                }

                public String getPkgName() {
                    return pkgName;
                }

                public void setPkgName(String pkgName) {
                    this.pkgName = pkgName;
                }

                public String getBackground() {
                    return background;
                }

                public void setBackground(String background) {
                    this.background = background;
                }

                public String getHeadUrl() {
                    return headUrl;
                }

                public void setHeadUrl(String headUrl) {
                    this.headUrl = headUrl;
                }
            }

            public static class ShareVideoBean {
                /**
                 * who : 小伟
                 * hintNum : 7
                 * actionType : 1
                 * actionUrl : xxxx
                 * className : className
                 * pkgName : pkgName
                 * background : ImgUrl or ImgType
                 * headUrl : url
                 */

                private String who;
                private int hintNum;
                private int actionType;
                private String actionUrl;
                private String className;
                private String pkgName;
                private String background;
                private String headUrl;

                public String getWho() {
                    return who;
                }

                public void setWho(String who) {
                    this.who = who;
                }

                public int getHintNum() {
                    return hintNum;
                }

                public void setHintNum(int hintNum) {
                    this.hintNum = hintNum;
                }

                public int getActionType() {
                    return actionType;
                }

                public void setActionType(int actionType) {
                    this.actionType = actionType;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public String getClassName() {
                    return className;
                }

                public void setClassName(String className) {
                    this.className = className;
                }

                public String getPkgName() {
                    return pkgName;
                }

                public void setPkgName(String pkgName) {
                    this.pkgName = pkgName;
                }

                public String getBackground() {
                    return background;
                }

                public void setBackground(String background) {
                    this.background = background;
                }

                public String getHeadUrl() {
                    return headUrl;
                }

                public void setHeadUrl(String headUrl) {
                    this.headUrl = headUrl;
                }
            }

            public static class ShareImgBean {
                /**
                 * who : 小伟
                 * hintNum : 7
                 * actionType : 1
                 * actionUrl : xxxx
                 * className : className
                 * pkgName : pkgName
                 * background : ImgUrl or ImgType
                 * headUrl : url
                 */

                private String who;
                private int hintNum;
                private int actionType;
                private String actionUrl;
                private String className;
                private String pkgName;
                private String background;
                private String headUrl;

                public String getWho() {
                    return who;
                }

                public void setWho(String who) {
                    this.who = who;
                }

                public int getHintNum() {
                    return hintNum;
                }

                public void setHintNum(int hintNum) {
                    this.hintNum = hintNum;
                }

                public int getActionType() {
                    return actionType;
                }

                public void setActionType(int actionType) {
                    this.actionType = actionType;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public String getClassName() {
                    return className;
                }

                public void setClassName(String className) {
                    this.className = className;
                }

                public String getPkgName() {
                    return pkgName;
                }

                public void setPkgName(String pkgName) {
                    this.pkgName = pkgName;
                }

                public String getBackground() {
                    return background;
                }

                public void setBackground(String background) {
                    this.background = background;
                }

                public String getHeadUrl() {
                    return headUrl;
                }

                public void setHeadUrl(String headUrl) {
                    this.headUrl = headUrl;
                }
            }

            public static class CallBean {
                /**
                 * who : 小伟
                 * hintNum : 7
                 * actionType : 1
                 * actionUrl : xxxx
                 * className : className
                 * pkgName : pkgName
                 * background : ImgUrl or ImgType
                 * hintBackground : ImgUrl or ImgType
                 */

                private String who;
                private int hintNum;
                private int actionType;
                private String actionUrl;
                private String className;
                private String pkgName;
                private String background;
                private String hintBackground;

                public String getWho() {
                    return who;
                }

                public void setWho(String who) {
                    this.who = who;
                }

                public int getHintNum() {
                    return hintNum;
                }

                public void setHintNum(int hintNum) {
                    this.hintNum = hintNum;
                }

                public int getActionType() {
                    return actionType;
                }

                public void setActionType(int actionType) {
                    this.actionType = actionType;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public String getClassName() {
                    return className;
                }

                public void setClassName(String className) {
                    this.className = className;
                }

                public String getPkgName() {
                    return pkgName;
                }

                public void setPkgName(String pkgName) {
                    this.pkgName = pkgName;
                }

                public String getBackground() {
                    return background;
                }

                public void setBackground(String background) {
                    this.background = background;
                }

                public String getHintBackground() {
                    return hintBackground;
                }

                public void setHintBackground(String hintBackground) {
                    this.hintBackground = hintBackground;
                }
            }
        }

        public static class SmartBean {
            /**
             * face : {"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","hintBackground":"ImgUrl or ImgType"}
             * voiceprint : {"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","hintBackground":"ImgUrl or ImgType"}
             * voice : {"actionType":1,"actionUrl":"xxxx","className":"className","pkgName":"pkgName","background":"ImgUrl or ImgType","hintBackground":"ImgUrl or ImgType"}
             */

            private FaceBean face;
            private VoiceprintBean voiceprint;
            private VoiceBean voice;

            public FaceBean getFace() {
                return face;
            }

            public void setFace(FaceBean face) {
                this.face = face;
            }

            public VoiceprintBean getVoiceprint() {
                return voiceprint;
            }

            public void setVoiceprint(VoiceprintBean voiceprint) {
                this.voiceprint = voiceprint;
            }

            public VoiceBean getVoice() {
                return voice;
            }

            public void setVoice(VoiceBean voice) {
                this.voice = voice;
            }

            public static class FaceBean {
                /**
                 * actionType : 1
                 * actionUrl : xxxx
                 * className : className
                 * pkgName : pkgName
                 * background : ImgUrl or ImgType
                 * hintBackground : ImgUrl or ImgType
                 */

                private int actionType;
                private String actionUrl;
                private String className;
                private String pkgName;
                private String background;
                private String hintBackground;

                public int getActionType() {
                    return actionType;
                }

                public void setActionType(int actionType) {
                    this.actionType = actionType;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public String getClassName() {
                    return className;
                }

                public void setClassName(String className) {
                    this.className = className;
                }

                public String getPkgName() {
                    return pkgName;
                }

                public void setPkgName(String pkgName) {
                    this.pkgName = pkgName;
                }

                public String getBackground() {
                    return background;
                }

                public void setBackground(String background) {
                    this.background = background;
                }

                public String getHintBackground() {
                    return hintBackground;
                }

                public void setHintBackground(String hintBackground) {
                    this.hintBackground = hintBackground;
                }
            }

            public static class VoiceprintBean {
                /**
                 * actionType : 1
                 * actionUrl : xxxx
                 * className : className
                 * pkgName : pkgName
                 * background : ImgUrl or ImgType
                 * hintBackground : ImgUrl or ImgType
                 */

                private int actionType;
                private String actionUrl;
                private String className;
                private String pkgName;
                private String background;
                private String hintBackground;

                public int getActionType() {
                    return actionType;
                }

                public void setActionType(int actionType) {
                    this.actionType = actionType;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public String getClassName() {
                    return className;
                }

                public void setClassName(String className) {
                    this.className = className;
                }

                public String getPkgName() {
                    return pkgName;
                }

                public void setPkgName(String pkgName) {
                    this.pkgName = pkgName;
                }

                public String getBackground() {
                    return background;
                }

                public void setBackground(String background) {
                    this.background = background;
                }

                public String getHintBackground() {
                    return hintBackground;
                }

                public void setHintBackground(String hintBackground) {
                    this.hintBackground = hintBackground;
                }
            }

            public static class VoiceBean {
                /**
                 * actionType : 1
                 * actionUrl : xxxx
                 * className : className
                 * pkgName : pkgName
                 * background : ImgUrl or ImgType
                 * hintBackground : ImgUrl or ImgType
                 */

                private int actionType;
                private String actionUrl;
                private String className;
                private String pkgName;
                private String background;
                private String hintBackground;

                public int getActionType() {
                    return actionType;
                }

                public void setActionType(int actionType) {
                    this.actionType = actionType;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public String getClassName() {
                    return className;
                }

                public void setClassName(String className) {
                    this.className = className;
                }

                public String getPkgName() {
                    return pkgName;
                }

                public void setPkgName(String pkgName) {
                    this.pkgName = pkgName;
                }

                public String getBackground() {
                    return background;
                }

                public void setBackground(String background) {
                    this.background = background;
                }

                public String getHintBackground() {
                    return hintBackground;
                }

                public void setHintBackground(String hintBackground) {
                    this.hintBackground = hintBackground;
                }
            }
        }
    }
}
