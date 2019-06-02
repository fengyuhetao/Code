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
//选择字体
$font = "msyhbd.ttc";
//填写水印内容
$content = "你好,何涛";
//设置字体的颜色RGB和透明度 参数1内存中的图片 2red 3green 4blue
$col = imagecolorallocatealpha($image, 255, 255, 255, 50);
//写入文字
imagettftext($image, 20, 0, 20, 100, $col, $font, $content);
/*输出图片*/
//浏览器输出
header("Content-type:".$info['mime']);
$fun = "image{$type}";
$fun($image);
//保存到电脑中
$fun($image,'newImage.'.$type);             //保存到电脑中失败取值！！！！！！！！！！！！！！！！！！！！
/*销毁图片*/
imagedestroy($image);
?>