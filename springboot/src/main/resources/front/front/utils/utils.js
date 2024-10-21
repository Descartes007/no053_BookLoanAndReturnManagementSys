// 跳转页面
const jump = (url) => {
	uni.navigateTo({
		url: url
	})
}
const tab = (url) => {
	uni.switchTab({
		url: url
	})
}
// 输出信息
const msg = (title, duration = 1500, mask = false, icon = 'none') => {
	//统一提示方便全局修改
	if (Boolean(title) === false) {
		return;
	}
	uni.showToast({
		title,
		duration,
		mask,
		icon
	});
}
const msgBack = (title, duration = 1500, delta = 1) => {
	if (!title) {
		return;
	}
	msg(title);
	setTimeout(function() {
		uni.navigateBack({
			delta: delta
		})
	}, duration);
}
const genTradeNo = () => {
	var date = new Date();
	var tradeNo = date.getFullYear().toString() + (date.getMonth() + 1).toString() +
		date.getDate().toString() + date.getHours().toString() + date.getMinutes().toString() +
		date.getSeconds().toString() + date.getMilliseconds().toString();
	for (var i = 0; i < 5; i++) //5位随机数，用以加在时间戳后面。
	{
		tradeNo += Math.floor(Math.random() * 10);
	}
	return tradeNo;
}
//获取当前时间（yyyy-MM-dd hh:mm:ss）
const getCurDateTime = () => {
	var currentTime = new Date(),
	year = currentTime.getFullYear(),
	month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
	day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
	hour = currentTime.getHours(),
	minute = currentTime.getMinutes(),
	second = currentTime.getSeconds();
	return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}
//获取当前日期（yyyy-MM-dd）
const getCurDate = () => {
	var currentTime = new Date(),
	year = currentTime.getFullYear(),
	month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
	day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
	return year + "-" + month + "-" + day;
}
export default {
	jump,
	msg,
	msgBack,
	tab,
	genTradeNo,
	getCurDateTime,
	getCurDate
}
