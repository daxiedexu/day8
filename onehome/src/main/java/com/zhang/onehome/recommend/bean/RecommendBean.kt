package com.zhang.onehome.recommend.bean

import com.google.gson.annotations.SerializedName
import com.zhang.onehome.recommend.bean.RecommendBean.DataBean

class RecommendBean {
    var code: Int? = null
    var data: MutableList<DataBean>? = null
    var msg: String? = null

    class DataBean {
        @SerializedName("CategoryId")
        var categoryId: Int? = null

        @SerializedName("CategoryName")
        var categoryName: String? = null

        @SerializedName("CommissionRate")
        var commissionRate: String? = null

        @SerializedName("CommissionType")
        var commissionType: String? = null

        @SerializedName("CouponAmount")
        var couponAmount: Any? = null

        @SerializedName("CouponEndTime")
        var couponEndTime: Any? = null

        @SerializedName("CouponId")
        var couponId: String? = null

        @SerializedName("CouponInfo")
        var couponInfo: String? = null

        @SerializedName("CouponRemainCount")
        var couponRemainCount: Int? = null

        @SerializedName("CouponShareUrl")
        var couponShareUrl: Any? = null

        @SerializedName("CouponStartFee")
        var couponStartFee: Any? = null

        @SerializedName("CouponStartTime")
        var couponStartTime: Any? = null

        @SerializedName("CouponTotalCount")
        var couponTotalCount: Int? = null

        @SerializedName("Distance")
        var distance: Any? = null

        @SerializedName("IncludeDxjh")
        var includeDxjh: String? = null

        @SerializedName("IncludeMkt")
        var includeMkt: String? = null

        @SerializedName("InfoDxjh")
        var infoDxjh: String? = null

        @SerializedName("ItemDescription")
        var itemDescription: String? = null

        @SerializedName("ItemId")
        var itemId: Long? = null

        @SerializedName("ItemUrl")
        var itemUrl: String? = null

        @SerializedName("JddNum")
        var jddNum: Int? = null

        @SerializedName("JddPrice")
        var jddPrice: Any? = null

        @SerializedName("KuadianPromotionInfo")
        var kuadianPromotionInfo: Any? = null

        @SerializedName("LevelOneCategoryId")
        var levelOneCategoryId: Int? = null

        @SerializedName("LevelOneCategoryName")
        var levelOneCategoryName: String? = null

        @SerializedName("LockRate")
        var lockRate: Any? = null

        @SerializedName("LockRateEndTime")
        var lockRateEndTime: Int? = null

        @SerializedName("LockRateStartTime")
        var lockRateStartTime: Int? = null

        @SerializedName("Nick")
        var nick: String? = null

        @SerializedName("NumIid")
        var numIid: Long? = null

        @SerializedName("Oetime")
        var oetime: Any? = null

        @SerializedName("OrigPrice")
        var origPrice: Any? = null

        @SerializedName("Ostime")
        var ostime: Any? = null

        @SerializedName("PictUrl")
        var pictUrl: String? = null

        @SerializedName("PresaleDeposit")
        var presaleDeposit: String? = null

        @SerializedName("PresaleDiscountFeeText")
        var presaleDiscountFeeText: Any? = null

        @SerializedName("PresaleEndTime")
        var presaleEndTime: Int? = null

        @SerializedName("PresaleStartTime")
        var presaleStartTime: Int? = null

        @SerializedName("PresaleTailEndTime")
        var presaleTailEndTime: Int? = null

        @SerializedName("PresaleTailStartTime")
        var presaleTailStartTime: Int? = null

        @SerializedName("Provcity")
        var provcity: String? = null

        @SerializedName("RealPostFee")
        var realPostFee: String? = null

        @SerializedName("ReservePrice")
        var reservePrice: String? = null

        @SerializedName("SaleBeginTime")
        var saleBeginTime: Any? = null

        @SerializedName("SaleEndTime")
        var saleEndTime: Any? = null

        @SerializedName("SalePrice")
        var salePrice: Any? = null

        @SerializedName("SellNum")
        var sellNum: Int? = null

        @SerializedName("SellerId")
        var sellerId: Long? = null

        @SerializedName("ShopDsr")
        var shopDsr: Int? = null

        @SerializedName("ShopTitle")
        var shopTitle: String? = null

        @SerializedName("ShortTitle")
        var shortTitle: String? = null

        @SerializedName("SmallImages")
        var smallImages: List<String>? = null

        @SerializedName("Stock")
        var stock: Int? = null

        @SerializedName("Title")
        var title: String? = null

        @SerializedName("TkTotalCommi")
        var tkTotalCommi: String? = null

        @SerializedName("TkTotalSales")
        var tkTotalSales: String? = null

        @SerializedName("TmallPlayActivityInfo")
        var tmallPlayActivityInfo: Any? = null

        @SerializedName("TotalStock")
        var totalStock: Int? = null

        @SerializedName("Url")
        var url: String? = null

        @SerializedName("UsableShopId")
        var usableShopId: Any? = null

        @SerializedName("UsableShopName")
        var usableShopName: Any? = null

        @SerializedName("UserType")
        var userType: Int? = null

        @SerializedName("UvSumPreSale")
        var uvSumPreSale: Int? = null

        @SerializedName("Volume")
        var volume: Int? = null

        @SerializedName("WhiteImage")
        var whiteImage: String? = null

        @SerializedName("XId")
        var xId: String? = null

        @SerializedName("YsylClickUrl")
        var ysylClickUrl: Any? = null

        @SerializedName("YsylCommissionRate")
        var ysylCommissionRate: Any? = null

        @SerializedName("YsylTljFace")
        var ysylTljFace: Any? = null

        @SerializedName("YsylTljSendTime")
        var ysylTljSendTime: Any? = null

        @SerializedName("YsylTljUseEndTime")
        var ysylTljUseEndTime: Any? = null

        @SerializedName("YsylTljUseStartTime")
        var ysylTljUseStartTime: Any? = null

        @SerializedName("ZkFinalPrice")
        var zkFinalPrice: String? = null
    }
}