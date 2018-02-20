<?php
$conn=mysqli_connect("localhost","id4040434_root","bitnami","id4040434_testedb");

if($conn)
{
	$nome=$_REQUEST['nome'];
	$id=$_REQUEST['id'];
	$password=$_REQUEST["password"];
	$insertLogin="Insert into login values ({$id},'{$nome}','{$password}')";

	$resultInsert=mysqli_query($conn, $insertLogin);
	if(!$resultInsert) { echo mysqli_connect_error(); }
}
?>
