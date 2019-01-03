/**
 * 
 * 格式化时间 
 * util
 */
const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  /**
   * 格式化时间 2019-01-01 19：19  by Jason.
   */
  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

/**
 * formatNumber 
 */
const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}

/**
 * commonErrorToast
 */
const commonErrorToast = () => {
  wx.showToast({
    /** 
     * server 服务异常  超时2000
     */
    title: text.serverError,
    icon: 'none',
    duration: 2000
  })
}

/**
 * formatTime -- 将方法暴露出去
 */
module.exports = {
  formatTime: formatTime
}
