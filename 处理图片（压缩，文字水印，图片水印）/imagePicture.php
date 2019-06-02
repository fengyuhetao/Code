<?php 
/*打开图片*/
//配置图片路径
$src = "001.jpg";
//获取图片信息(通过GD库提供的方法，得到想处理图片的基本信息)
$info = getimagesize(($src));
//通过图像的编号来获取图像的编号
$type = image_type_to_extension($info[2],false);
//在内存中创建一个和图像类型一样的图像
// $func = "imagecreatefrom".$type;
$func = "imagecreatefrom{$type}";
//把图片复制到内存中
$image = $func($src);
/*操作图片*/
//设置水印路径
$image_Mark = "002.jpg";
//获取水印图片基本不信息
$info2 = getimagesize($image_Mark);
//获得水印图片类型
$type2 = image_type_to_extension($info2[2],false);
//设置函数
$fun2 = "imagecreatefrom{$type2}";
//将图片复制到内存中
$water = $fun2($image_Mark);
//合并图片
imagecopymerge($image, $water, 20, 30, 0, 0, $info2[0], $info2[1], 30);
//销毁水印图片
imagedestroy($water);
/*输出图片*/
//浏览器输出
header("Content-type:".$info['mime']);
$fun = "image{$type}";
$fun($image);
//保存到电脑中
$fun($image,'water.'.$type);             //保存到电脑中失败取值！！！！！！！！！！！！！！！！！！！！
/*销毁图片*/
imagedestroy($image);
?>