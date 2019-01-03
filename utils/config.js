/**
 * config  - 配置
 */
module.exports = {

  /**
   * ajaxData
   */
  ajaxData: {
    /**
     * 获取今天的信息
     */
    today: {

       //url:  'http://127.0.0.1:9092/oneday/v1/oneday',
      url: 'https://api.hunterblog.cn/oneday/v1/oneday',
      //url: 'https://dev.xdooi.com/today',

      /**
       * 封装请求的data数据
       */
      //data: {
        //dateTime:'2019-01-01',
        //sign:'You are what you want to be.',
        //token:'please do it just!'

      //}
    },

    /**
     * 获取top页面图片信息
     */
    getTopImg: {
      /**
       * 这里是获取图片的地址 bing搜索引擎上面获取！
       * 
       *    -- 这里的api可能随时会变动注意同步更换  --- By Jason
       */
      url: 'https://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1',

      /**
       * 封装请求的data数据
       */
      data: {

      }
    }
  },

  /**
   * href 
   */
  href: {
    /**
     * 链接指向数据
     */
    topImg: 'https://dev.xdooi.com/bingimage/bgTop.jpg'
  },

  thridApi:{
    poemApiUrl:'https://v2.jinrishici.com/one.svg?font-size=15&spacing=2&color=red'
  },

  /**
   * 错误提示 - text
   */
  text: {
    serverError: '网络似乎有问题，请稍后重试...',
    shareTitle: '快来查看你的今日幸运签吧',
    shareTitle2: '长按查看你的今日幸运签'
  }
}