<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>汽车浏览</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="icon" href="favicon.ico">
	<link rel="stylesheet" href="${rincar }/resources/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${rincar }/resources/css/public.css" media="all" />
</head>
<body class="childrenBody">
	<!-- 搜索条件开始 -->
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
	  <legend>查询条件</legend>
	</fieldset>
	<form class="layui-form" method="post" id="searchFrm">
		<div class="layui-form-item">
			<div class="layui-inline">
		      <label class="layui-form-label">车牌号:</label>
		      <div class="layui-input-inline">
		        <input type="text" name="carnumber"  autocomplete="off" class="layui-input">
		      </div>
		    </div>
		    <div class="layui-inline">
		      <label class="layui-form-label">车辆类型:</label>
		      <div class="layui-input-inline">
		        <input type="text" name="cartype"  autocomplete="off" class="layui-input">
		      </div>
		    </div>
		    <div class="layui-inline">
		      <label class="layui-form-label">车辆颜色:</label>
		      <div class="layui-input-inline">
		        <input type="text" name="color"  autocomplete="off" class="layui-input">
		      </div>
		    </div>
		 
		
		    <div class="layui-inline">
		      <label class="layui-form-label">车辆描述:</label>
		      <div class="layui-input-inline">
		        <input type="text" name="description"  autocomplete="off" class="layui-input">
		      </div>
		    </div>
		    
		</div>
		 <div class="layui-inline">
		      <label class="layui-form-label">是否出租:</label>
		      <div class="layui-input-inline">
		       		 <input type="radio" name="isrenting" value="1" title="已出租">
					 <input type="radio" name="isrenting" value="0" title="未出租">
		      </div>
		    </div>
		 <div  class="layui-form-item" style="text-align: center;">
		  <div class="layui-input-block" >
		      <button type="button" class="layui-btn layui-btn-normal  layui-icon layui-icon-search" id="doSearch">查询</button>
		      <button type="reset" class="layui-btn layui-btn-warm  layui-icon layui-icon-refresh">重置</button>
		    </div>
		 </div>
	</form>
	
	<!-- 搜索条件结束 -->
	
	<!-- 数据表格开始 -->
	<table class="layui-hide" id="carTable" lay-filter="carTable"></table>
	
	<div  id="carToolBar" style="display: none;">
		
	</div>
	<script type="text/html"  id="carBar">
		 {{#  if(d.isrenting ==1){ }}
			 <a class="layui-btn layui-btn-xs layui-btn-disabled">预定</a>
	  		<a class="layui-btn layui-btn-xs"  lay-event="viewImage">查看大图</a>

 		 {{#  } else{ }}
	  		 <a class="layui-btn layui-btn-xs" lay-event="rentCar">预定</a>
	 		 <a class="layui-btn layui-btn-xs" lay-event="viewImage">查看大图</a>
  		 {{#  } }}	  
	</script>
	<!-- 数据表格结束 -->
	
	<!-- 添加和修改的弹出层开始 -->
	<div style="display: none;padding: 20px" id="saveOrUpdateDiv" >
		<form class="layui-form"  lay-filter="dataFrm" id="dataFrm">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">起租时间:</label>
					<div class="layui-input-inline">
						<input type="text" name="begindate"  id="begindate" placeholder="请输入起租时间"  autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">还车时间:</label>
					<div class="layui-input-inline">
						<input type="text" name="returndate"  id="returndate" placeholder="请输入还车时间"  autocomplete="off"
							class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">出租单号:</label>
				<div class="layui-input-block">
					<input type="text" name="rentid" lay-verify="required"  readonly="readonly"  placeholder="请输入出租单号" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">身份证号:</label>
				<div class="layui-input-block">
					<input type="text" name="identity" lay-verify="required" readonly="readonly"  placeholder="请输入身份证号" autocomplete="off"
						class="layui-input" >
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">车牌号:</label>
					<div class="layui-input-inline">
						<input type="text" name="carnumber" lay-verify="required"  readonly="readonly"  placeholder="请输入车牌号" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">出租价格:</label>
					<div class="layui-input-inline">
						<input type="text" name="price" lay-verify="required"   placeholder="请输入出租价格" autocomplete="off"
							class="layui-input" readonly="readonly">
					</div>
				</div>
			</div>
			<div class="layui-form-item" style="text-align: center;">
			    <div class="layui-input-block">
			      <button type="button" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release" lay-filter="doSubmit" lay-submit="">提交</button>
			      <button type="reset" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-refresh" >重置</button>
			    </div>
		  	</div>
		
		</form>
	</div>
	<!-- 添加和修改的弹出层结束 -->
	
	
	<!-- 查看大图弹出的层 开始 -->
	<div id="viewCarImageDiv" style="display: none;text-align: center;">
		<img alt="车辆图片" width="550" height="350" id="view_carimg">
	</div>
	<!-- 查看大图弹出的层 结束 -->
	
	<script src="${rincar }/resources/layui/layui.js"></script>
	<script type="text/javascript">
	    var tableIns;
	    layui.use([ 'jquery', 'layer', 'form', 'table','upload','laydate'  ], function() {
			var $ = layui.jquery;
			var layer = layui.layer;
			var form = layui.form;
			var table = layui.table;
			var upload=layui.upload;
			var laydate=layui.laydate;
			
			laydate.render({
				elem:'#begindate',
				type:'datetime'
			});
			laydate.render({
				elem:'#returndate',
				type:'datetime'
			});
			
			//渲染数据表格
			 tableIns=table.render({
				 elem: '#carTable'   //渲染的目标对象
			    ,url:'${rincar}/car/loadAllCar.action' //数据接口
			    ,title: '车辆数据表'//数据导出来的标题
			    ,toolbar:"#carToolBar"   //表格的工具条
			    ,height:'full-220'
			    ,cellMinWidth:100 //设置列的最小默认宽度
			    ,page: true  //是否启用分页
			    ,cols: [[   //列表数据
			      {field:'carnumber', title:'车牌号',align:'center',width:'120'}
			      ,{field:'cartype', title:'车辆类型',align:'center',width:'100'}
			      ,{field:'color', title:'车辆颜色',align:'center',width:'120'}
			      ,{field:'price', title:'购买价格',align:'center',width:'150'}
			      ,{field:'rentprice', title:'出租价格',align:'center',width:'120'}
			      ,{field:'deposit', title:'出租押金',align:'center',width:'120'}
			      ,{field:'isrenting', title:'出租状态',align:'center',width:'100',templet:function(d){
			    	  if(d.isrenting=='1'){
			    		  return '<font color=blue>已出租</font>';
			    	  }else{
			    		  return '<font color=red>未出租</font>';
			    	  }
			      }}
			      ,{field:'description', title:'车辆描述',align:'center',width:'180'}
			      ,{field:'carimg', title:'缩略图',align:'center',width:'120',templet:function(d){
			    	  return "<img width=40 height=30 src=${rincar}/file/downloadShowFile.action?path="+d.carimg+" />";
			      }}
			      ,{fixed: 'right', title:'操作', toolbar: '#carBar', width:220,align:'center'}
			    ]],
			    done:function(data,curr,count){
			    	//不是第一页时如果当前返回的的数据为0那么就返回上一页
			    	if(data.data.length==0&&curr!=1){
			    		tableIns.reload({
						    page:{
						    	curr:curr-1
						    }
						});
			    	}
			    }
			})
		
			//模糊查询
			$("#doSearch").click(function(){
				var params=$("#searchFrm").serialize();
				tableIns.reload({
					url:"${rincar}/car/loadAllCar.action?"+params ,
				    page:{
				    	curr:1
				    }
				})
			});
			
			
			//监听行工具事件
		   table.on('tool(carTable)', function(obj){
			   var data = obj.data; //获得当前行数据
			   var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			  if(layEvent === 'rentCar'){ //预定
				   openRentCar(data);
			   }else if(layEvent==='viewImage'){
				   showCarImage(data);
			   } 
			 });

		   var mainIndex;
			//打开添加页面
			function openRentCar(data){
				mainIndex=layer.open({
					type:1,
					title:'添加汽车出租',
					content:$("#saveOrUpdateDiv"),
					area:['800px','500px'],
					success:function(index){
						//清空表单数据       
						$("#dataFrm")[0].reset();
						//请求数据
						var price=data.rentprice;
						var carnumber=data.carnumber;						
						$.get("${rincar}/rent/initRentFrom.action",{
							price:price,
							carnumber:carnumber
						},function(obj){//---obj---RentVo
							//赋值
							form.val("dataFrm",obj);
						})
					}
				});
			}
			//保存
			form.on("submit(doSubmit)",function(obj){
				//序列化表单数据
				var params=$("#dataFrm").serialize();
				$.post("${rincar}/rent/saveRent.action",params,function(obj){
					layer.msg(obj.msg);
					//关闭弹出层
					layer.close(mainIndex)
					$("#content").hide();
					//刷新数据 表格
					tableIns.reload();
				})
			});
		
		   
			//查看大图
			function showCarImage(data){
				
				mainIndex=layer.open({
					type:1,
					title:"【"+data.carnumber+'】的车辆图片',
					content:$("#viewCarImageDiv"),
					area:['600px','400px'],
					success:function(index){
						$("#view_carimg").attr("src","${rincar}/file/downloadShowFile.action?path="+data.carimg);
					}
				});
			}
		});
	</script>
</body>
</html>