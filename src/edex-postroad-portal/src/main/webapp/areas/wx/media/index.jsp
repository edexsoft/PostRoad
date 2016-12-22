<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/cdn/mobile/sui/1.4.2/css/sui.css" />
</head>
<body>
	/wx/media/index
	</br>
	<h3 id="menu-image">图像接口</h3>
	<span class="desc">拍照或从手机相册中选图接口</span>
	<button class="btn btn_primary" id="chooseImage">chooseImage</button>
	<span class="desc">预览图片接口</span>
	<button class="btn btn_primary" id="previewImage">previewImage</button>
	<span class="desc">上传图片接口</span>
	<button class="btn btn_primary" id="uploadImage">uploadImage</button>
	<span class="desc">下载图片接口</span>
	<button class="btn btn_primary" id="downloadImage">downloadImage</button>

	<script type="text/javascript" src="/cdn/mobile/zepto/1.2.0/zepto.js"></script>
	<!--  
	<script type="text/javascript" src="/cdn/mobile/sui/1.4.2/js/sui.js"></script>
	-->
	<script type="text/javascript" src="/cdn/themes/wx/jweixin-1.0.0.js"></script>
	<script type="text/javascript" src="/cdn/themes/wx/wx.config.js"></script>
	<script type="text/javascript">
		$.ajax({
			url:'/api/wx/wxjssdk/wxconfig?requestUrl='+ encodeURI(location.href) +'&t=' + new Date(),
			method:'GET',
			async:true,
			dataType:'json',
			success:function(data, textStatus, jqXHR) {
				if(data.ResultCode<0)
				{
					alert('获取微信配置失败');
					//location.href='';
					return;
				}
				var wxConfig=$.extend(true, {}, wx_config, data.Data);
				wx.config(wxConfig);
			},
			error:function(jqXHR, textStatus, errorThrown) {
			   //alert( "error" );
			}
		});
		

		// config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，
		// config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。
		// 对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
		wx.ready(function(){

		});
		
		// config信息验证失败会执行error函数，如签名过期导致验证失败，
		// 具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
		wx.error(function(res){

		});
		
		// 5 图片接口
		  // 5.1 拍照、本地选图
		  var images = {
		    localId: [],
		    serverId: []
		  };
		  document.querySelector('#chooseImage').onclick = function () {
		    wx.chooseImage({
		      success: function (res) {
		        images.localId = res.localIds;
		        alert('已选择 ' + res.localIds.length + ' 张图片');
		      }
		    });
		  };

		  // 5.2 图片预览
		  document.querySelector('#previewImage').onclick = function () {
		    wx.previewImage({
		      current: 'http://img5.douban.com/view/photo/photo/public/p1353993776.jpg',
		      urls: [
		        'http://img3.douban.com/view/photo/photo/public/p2152117150.jpg',
		        'http://img5.douban.com/view/photo/photo/public/p1353993776.jpg',
		        'http://img3.douban.com/view/photo/photo/public/p2152134700.jpg'
		      ]
		    });
		  };

		  // 5.3 上传图片
		  document.querySelector('#uploadImage').onclick = function () {
		    if (images.localId.length == 0) {
		      alert('请先使用 chooseImage 接口选择图片');
		      return;
		    }
		    var i = 0, length = images.localId.length;
		    images.serverId = [];
		    function upload() {
		      wx.uploadImage({
		        localId: images.localId[i],
		        success: function (res) {
		          i++;
		          //alert('已上传：' + i + '/' + length);
		          images.serverId.push(res.serverId);
		          if (i < length) {
		            upload();
		          }
		        },
		        fail: function (res) {
		          alert(JSON.stringify(res));
		        }
		      });
		    }
		    upload();
		  };

		  // 5.4 下载图片
		  document.querySelector('#downloadImage').onclick = function () {
		    if (images.serverId.length === 0) {
		      alert('请先使用 uploadImage 上传图片');
		      return;
		    }
		    var i = 0, length = images.serverId.length;
		    images.localId = [];
		    function download() {
		      wx.downloadImage({
		        serverId: images.serverId[i],
		        success: function (res) {
		          i++;
		          alert('已下载：' + i + '/' + length);
		          images.localId.push(res.localId);
		          if (i < length) {
		            download();
		          }
		        }
		      });
		    }
		    download();
		  };

	</script>
</body>
</html>