/**
 * getApp 
 */
const app = getApp()

/**
 *  { ajaxData, href, text } 定义常量
 */
const { ajaxData, href, text } = app.globalData.config

/**
 * API
 */
module.exports = {

  /**
   * ajaxData 
   */
  API: (ajaxData, callback) => {
    /**
     * reqData  - json序列化
     */
    const reqData = ajaxData.data ? JSON.stringify(ajaxData.data) : JSON.stringify({})

    /**
     * data{"reqData":reqData}
     */
    const data = {
      reqData: reqData,
    }

    /**
     * request
     */
    wx.request({
      url: ajaxData.url,
      data: data,
      success: function (res) {
        console.log('Page最终数据:', res.data)
        callback && callback(res.data)
      },
      /**
       * fail 
       */
      fail: function(res) {
        wx.showToast({
          title: text.serverError,
          icon: 'none',
          duration: 2000
        })
      }
    })
  }
}