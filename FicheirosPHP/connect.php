<?php 
$conn=mysqli_connect("localhost","id4040434_root","bitnami","id4040434_testedb");

if(!$conn)
{
	echo "Nao conectado"; ?><html> <br></html><?php
}
else
{
	echo "Conectado";?><html> <br></html><?php
	$sqlQuery="select * from login";
	$resultQuery=mysqli_query($conn, $sqlQuery);
	
	if(mysqli_num_rows($resultQuery) > 0)
	{
		while($row = mysqli_fetch_assoc($resultQuery))
		{
			var_dump($row);			
			echo $row['id'];?><html> <br></html><?php
			echo $row['nome'];?><html> <br></html><?php
		}
	}
}
?>
