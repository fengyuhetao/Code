<?php 
	session_start();
	
	$table = array(
		'1',
		'2',
		'3'
		);

	$index = rand(0, 2);

	$value = $table[$index];
	$_SESSION['authcode'] = $value;

	$filename = $value.'.jpg';
	$contents = file_get_contents($filename);

	header('content-type: image/jpg');

	echo $contents;
?>