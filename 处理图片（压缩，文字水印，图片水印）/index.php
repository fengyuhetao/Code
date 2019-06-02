<?php 
include "image.class.php";
$src = "001.jpg";
$image = new image($src);

//生成缩略图
// $image->thumb(300,200);

//添加文字水印
//$font_url = "msyhbd.ttc";
//填写水印内容
// $content = "你好,何涛";
// $size= 20;
// $color = array(
// 	0 => 255,
// 	1 => 255,
// 	2 => 255,
// 	3 => 20,
// 	);
// $local = array(
// 	'x' => 20,
// 	'y' => 50,
// 	);
// $angle = 10;
// $image->fontMark($content, $font_url, $size, $color, $local, $angle);

//添加图片水印
$source = '002.jpg';
$local = array(
	'x' => 20,
	'y' => 40
	);
$alpha = 30;
$image -> imageMark($source, $local, $alpha);
$image->show();
?>