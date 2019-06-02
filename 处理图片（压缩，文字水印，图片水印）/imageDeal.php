<?php 
/*打开图片*/
//配置图片路径
$src = "001.jpg";
//获取图片信息(通过GD库提供的方法，得到想处理图片的基本信息)
$info = getimagesize(($src));
//通过图像的编号来获取图像的编号
$type = image_type_to_extension($info[2],false);
//在内存中创建一个和图像类型一样的图像
$func = "imagecreatefrom".$type;
//把图片复制到内存中
$image = $func($src);
/*操作图片*/
//在内存中建立一个宽300，高200的真色彩图片
$image_thumb = imagecreatetruecolor(500, 200);
//核心步骤 将原图像复制到新的真色彩图片上，并且按照一定的比例压缩
imagecopyresampled($image_thumb, $image, 0, 0, 0, 0, 500, 200, $info[0], $info[1]);
//销毁原图片
imagedestroy($image);
/*输出图片*/
//输出到浏览器
header('Content-type:'.$info['mime']);
$funs = "image{$type}";
$funs($image_thumb);
//保存到硬盘里
$funs($image_thumb,'thumb_image.'.$type);
/*销毁图片*/
imagedestroy($image_thumb);
?>