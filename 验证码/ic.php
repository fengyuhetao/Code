<?php 
	session_start();
	$image = imagecreatetruecolor(200, 100);
	$bgcolor = imagecolorallocate($image, 255, 255, 255);
	imagefill($image, 0, 0, $bgcolor);

	/*for($i = 0; $i < 4; $i++){
		$fontsize = 20;
		$fontcolor = imagecolorallocate($image, rand(0, 120), rand(0, 120), rand(0, 120));
		$fontcontent = rand(0, 9);
		$x = ($i*100/4)+rand(5, 10);
		$y = rand(5, 10);
		imagestring($image, $fontsize, $x, $y, $fontcontent, $fontcolor);
	}*/

	$captch_code = '';
	for($i = 0; $i < 4; $i++){
		$fontsize = 20;
		$fontcolor = imagecolorallocate($image, rand(0, 120), rand(0, 120), rand(0, 120));
		$data = 'abcdefghijklmnopqrstuvwxyz1234567890';
		$fontcontent = substr($data, rand(1, strlen($data)), 1);
		$captch_code .= $fontcontent;
		$x = ($i*100/4)+rand(5, 10);
		$y = rand(5, 10);
		imagestring($image, $fontsize, $x, $y, $fontcontent, $fontcolor);
	}
	$_SESSION['authcode'] = $captch_code;

	for($i = 0; $i < 300; $i++){
		$pointcolor = imagecolorallocate($image, rand(50, 200), rand(50, 200),rand(50, 200));
		imagesetpixel($image, rand(1, 199), rand(1, 99), $pointcolor);
	}

	for($i = 0;$i < 3; $i++){
		$linecolor = imagecolorallocate($image, rand(80, 220), rand(80, 220), rand(80, 220));
		imageline($image, rand(1, 199), rand(1, 99), rand(1, 199), rand(1, 99), $linecolor);
	}
	header('content-type: image/png');
	imagepng($image);
	//destory$image
	imagedestroy($image);

?>