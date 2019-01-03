/**
 * 引入API
 */
const {API} = require('../../utils/api.js')

const TodayPoem = require('../../utils/thridApi/jinrishici.js')

/**
 * 获取app对象
 */
const app = getApp()

/**
 * 定义全局的配置变量
 */
const { ajaxData, href, text, thridApi} = app.globalData.config

/**
 * 获取设备的屏幕的 宽度 - 高度 - 分辨率
 */
const { screenWidth, screenHeight, pixelRatio} = wx.getSystemInfoSync()

/** 
 * 初始化Page对象
 */
Page({

  /**
   * data信息
   */
  data: {
    topBgUrl: '', //顶部背景图URL
    copyright: '',//版权信息
    todayData: {}, //todayData当天的数据信息
    isCopyrightHidden: true //显示版权信息
  },

  /**
   * 加载的时候获取图片信息  获取今天的date   据
   */
  onLoad: function () {
    this.fetchImgData()
    this.fetchTodayData()
    //this.fetchPoem()
  },

  /**
   * 超时处理
   */
  onReady: function () {
    setTimeout(() => {
      this.setData({
        isCopyrightHidden: false
      })
    }, 1000)
  },

  /**
   * 分享的配置
   */
  onShareAppMessage: function () {
    return {
      title: text.shareTitle,
      path: '/pages/index/index'
    }
  },

  /**
   * 获取图片数据
   */
  fetchImgData: function() {

    /**
     * 异步获取数据入参
     *      getTopImg ： 顶部的图片Url
     *            topBgUrl ： 顶部图片的地址
     *            copyright： 版权信息
     */
    API(ajaxData.getTopImg, data => {
      if (data.images.length > 0) { //存在图片的时候

        /**
         * 解析出来这里面的数据 然后拼接起来 请求访问
         *     第一个图片[0]
         *     第一个图片对应的版权信息
         */
        this.setData({
          topBgUrl: `https://cn.bing.com${data.images[0].url}`,
          copyright: data.images[0].copyright,
          thridApiUrl: thridApi.poemApiUrl
        })
        //console.log(this.data)
      }else{ //如果不存在图片  -- or 解析异常 采用默认的方式设置几个图片
          /**
           * topBgUrl - 默认的图片地址
           */
          this.setData({
            topBgUrl: `https://www.baidu.com`,  //可以采用默认的assets对应的文件地址
            copyright: 'JasonInternational@LTD,.CD',
          })
      }
    })
  },

  /**
   * 获取诗句
   */
  fetchPoem:function(){

    TodayPoem.load(result => {
      console.log(result)
      try {
        const slogan = wx.getStorageSync('slogan') //标号
      } catch (e) {
        console.log(e)
      }
      /**
       * 今日诗词
       */
      this.setData({ "jinrishici": result.data.content })
    })
  },

  /**
   * 获取当前的数据
   */
  fetchTodayData: function() {

    /**
     * 获取当天的数据  -- 年月日  宜or忌   API数据结构
     * {
     *      "avoid": {
     *         "msg": "搞学习"
     *     },
     *     "day": 02,
     *     "lunar": "You are what you want to be.",
     *     "month": 01,
     *     "slogan": "勿忘初心，方得始终！",
     *     "suitable": {
     *         "msg": "睡觉觉"
     *     },
     *     "time": 1546424942685,
     *     "week": "星期一",
     *     "year": "2019"
     * }
     */
    API(ajaxData.today, data => {
      /**
       * reqData:
       *      url: 'https://dev.xdooi.com/today',
       *      data:{  }
       */

      /**
       * 如果有数据返回
       */

      if (data) {
        var data = data.result; // data.result 
        try {
          //const slogan = wx.getStorageSync('slogan') //标号
          const suitable = wx.getStorageSync('suitable') //宜
          const avoid = wx.getStorageSync('avoid')//忌
          const time = wx.getStorageSync('time')//时间
          //const testDate = wx.getStorageSync('testDate')

          /**
           * 当前的时间  == 请求的时间
           */
          if (time === data.time) {
            data.slogan = slogan
            data.suitable = suitable
            data.avoid = avoid
          }

          this.setData({
            todayData:data
          })
        } catch (e) {

          /**
           * 打印异常信息
           */
          console.log(e)
        }

        /**
         * 将数据缓存下来
         */
        try {
          wx.setStorageSync('slogan', data.slogan)
          wx.setStorageSync('suitable', data.suitable)
          wx.setStorageSync('avoid', data.avoid)
          wx.setStorageSync('time', data.time)
          // wx.setStorageSync('testDate', data.testDate)
        } catch (e) {
          console.log(e)
        }
      }

      /**
       * 生成的分享的图片 数据
       */
      // this.generalShareImg(this.data.todayData)
    })
  },

  /**
   * 预览图片
   */
  bindImageTap: function() {
    wx.previewImage({
      urls: [this.data.topBgUrl],
    })
  },

  /**
   * generalShareImg    -- 生成分享图片
   */
  bindShareTap: function() {
    this.generalShareImg(this.data.todayData)
  },

  /**
   * generalShareImg 
   */
  generalShareImg: function(data) {

    /**
     * createCanvasContext 利用Canvas来生成分享图片.
     */
    const ctx = wx.createCanvasContext('share-canvas', this)

    /**
     * 展示生成图片中
     */
    wx.showLoading({
      title: '佛系小吴生成图片中...',
      mask: true
    })

    /**
     * Promise 
     */
    new Promise(resolve => {

      /**
       * 获取image信息
       *        src: href.topImg  ： topImg: 'https://dev.xdooi.com/bingimage/bgTop.jpg'
       */
      wx.getImageInfo({
        src: href.topImg,
        success: res => {
          /**
           * 画图  -- screenWidth 屏幕宽度
           */
          ctx.drawImage(res.path, 0, 0, screenWidth, 210)
          resolve()
        }
      })
    }).then(() => new Promise(resolve => {
      ctx.rect(0, 210, screenWidth, 470)
      ctx.setFillStyle('#fff')
      ctx.fill() //刷流

      ctx.beginPath()
      ctx.rect(20, 156, screenWidth*0.893, 409)
      ctx.setFillStyle('#fff')
      ctx.setShadow(0, 5, 25, 'rgba(0, 42, 110, 0.15)')
      ctx.fill()

      ctx.setFontSize(15)
      ctx.setTextAlign('center')
      ctx.setFillStyle('#444')
      ctx.fillText(`${data.year}年${data.month}月`, screenWidth / 2, 195)

      ctx.setFontSize(12)
      ctx.setTextAlign('center')
      ctx.setFillStyle('#444')
      ctx.fillText(data.lunar, screenWidth / 2, 215)

      ctx.setFontSize(100)
      ctx.setTextAlign('center')
      ctx.setFillStyle('#444')
      ctx.fillText(data.day, screenWidth / 2, 315)

      ctx.setFontSize(15)
      ctx.setTextAlign('center')
      ctx.setFillStyle('#444')
      ctx.fillText(data.week, screenWidth / 2, 350)

      ctx.drawImage('/assets/quo-left.png', 45, 390, 11, 11)

      const lineNum = screenWidth > 320 ? 14 : 11

      /**
       * 如果标号的长度>lineNum
       */
      if (data.slogan.length > lineNum) {

        /**
         * 对标语进行文字处理
         */
        const text1 = data.slogan.substring(0, lineNum)
        const text2Temp = data.slogan.substring(lineNum, data.slogan.length)
        const text2 = text2Temp.length > lineNum ? `${text2Temp.substring(0, lineNum)}...` : text2Temp

        ctx.setFontSize(17)
        ctx.setTextAlign('center')
        ctx.setFillStyle('#333')
        ctx.fillText(text1, screenWidth / 2, 405, 247)

        ctx.setFontSize(17)
        ctx.setTextAlign('center')
        ctx.setFillStyle('#333')
        ctx.fillText(text2, screenWidth / 2, 432, 247)
      } else {
        ctx.fillText(data.slogan, screenWidth / 2, 405, 247)
      }

      ctx.drawImage('/assets/quo-right.png', screenWidth * 0.85, 408, 11, 11)

      ctx.beginPath()
      ctx.rect(47.5, 465, screenWidth * 0.747, 1)
      ctx.setFillStyle('#C7C7C7')
      ctx.fill()

      ctx.beginPath()
      ctx.rect(47.5, 468, screenWidth * 0.747, 0.5)
      ctx.setFillStyle('#C7C7C7')
      ctx.fill()

      ctx.drawImage('/assets/yi-icon.png', 60, 492, 30, 30)

      ctx.beginPath()
      ctx.rect(100, 505, 4, 4)
      ctx.setFillStyle('#4B4B4B')
      ctx.fill()

      ctx.setFontSize(screenWidth > 320 ? 17 : 14)
      ctx.setFillStyle('#333')
      ctx.fillText(data.suitable, 110 + (data.suitable.length * 17) / 2, 513)

      ctx.drawImage('/assets/ji-icon.png', screenWidth > 320 ? 210 : 190, 492, 30, 30)

      ctx.beginPath()
      ctx.rect(screenWidth > 320 ? 250 : 230, 505, 4, 4)
      ctx.setFillStyle('#4B4B4B')
      ctx.fill()

      ctx.setFontSize(screenWidth > 320 ? 17 : 14)
      ctx.setFillStyle('#333')
      ctx.fillText(data.avoid, (screenWidth > 320 ? 260 : 235) + (data.avoid.length * 17) / 2, 513)

      ctx.drawImage('/assets/qrcode.png', screenWidth / 2 - 40, 575, 80, 80)

      ctx.setFontSize(12)
      ctx.setTextAlign('center')
      ctx.setFillStyle('#333')
      ctx.fillText(text.shareTitle2, screenWidth / 2, 670)

      ctx.draw()
  
      setTimeout(() => resolve(), 1000)  //设置超时1000ms
    })).then(() => {
      //隐藏加载loading Tips
      wx.hideLoading()

      wx.canvasToTempFilePath({
        canvasId: 'share-canvas',
        x: 0,
        y: 0,
        width: screenWidth,
        height: 736,
        success: res => {

          /**
           * tempFilePath 图片指向一个临时的文件路径  -- 保存到相册
           */
          wx.saveImageToPhotosAlbum({
            filePath: res.tempFilePath,
            success(res) {
              wx.showToast({
                title: '生成图片成功',
                duration: 2000
              })
            }
          })
        },
        fail: () => {
          wx.showToast({
            title: '生成图片失败',
            duration: 2000
          })
        }
      }, this)
    })
  }
})
