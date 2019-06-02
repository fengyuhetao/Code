<?php 

class image{
	/**
	 * 图片信息
	 */
	private $info;

	/**
	 * 保存到内存中的图片
	 */
	private $image;

	/**
	 * 打开一个图片，读取到内存中
	 */
	//构造函数
	Public function __construct($src){
		$info = getimagesize($src);
		$this->info = array(
			'width' => $info[0],
			'height' => $info[1],
			'type' => image_type_to_extension($info[2],false),
			'mime' => $info['mime'],
		);
		$fun = "imagecreatefrom{$this->info['type']}";
		$this->image = $fun($src);
	}

	/**
	 * 操作图片(压缩)
	 */
	Public function thumb($width, $height){
		$image_thumb = imagecreatetruecolor($width, $height);
		imagecopyresampled($image_thumb, $this->image, 0, 0, 0, 0, $width, $height, $this->info['width'], $this->info['width']);
		imagedestroy($this->image);
		$this->image = $image_thumb;
	}

	/** 
	 * 操作图片(添加文字水印)
	 */
	Public function fontMark($content, $font_url, $size, $color, $local, $angle){
		$col = imagecolorallocatealpha($this->image, $color[0], $color[1], $color[2], $color[3]);
		imagettftext($this->image, $size, $angle, $local['x'], $local['y'], $col, $font_url, $content);
	}

	/**
	 * 操作图片(添加图片水印)
     */
	Public function imageMark($source, $local, $alpha){
		$info2 = getimagesize($source);
		$type2 = image_type_to_extension($info2[2], false);
		$fun2 = "imagecreatefrom{$type2}";
		$water = $fun2($source);
		imagecopymerge($this->image, $water, $local['x'], $local['y'], 0, 0, $info2[0], $info2[1], $alpha);
		imagedestroy($water);
	}

	/**
	 * 在浏览器中输出图片
	 */
	Public function show(){
		header('Content-type:'.$this->info['mime']);
		$funs = "image{$this->info['type']}";
		$funs($this->image);
	}

	/**
	 * 把图片保存到硬盘里
	 */
	Public function save($newName){
		$funs = "image{$this->info['type']}";
		$funs($this->image,$newName);
	}

	/**
	 * 析构函数
	 */
	Public function __destruct(){
		imagedestroy($this->image);
	}
}
?>