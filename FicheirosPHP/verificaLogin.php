<?php
$conn=mysqli_connect("localhost","id4040434_root","bitnami","id4040434_testedb");

if($conn)
{
	$id=$_REQUEST['id'];
	$password=$_REQUEST['password'];
	
	$sqlVerificaLogin="Select id,password from login where id={$id} and password='{$password}'";
	$resultVerificaLogin=mysqli_query($conn, $sqlVerificaLogin);

	if (mysqli_num_rows($resultVerificaLogin) > 0)
	{
		echo "1";
	}
	else
	{
		echo "0";
	}
}
?>
