<?php
require_once 'koneksi.php';
if($_SERVER['REQUEST_METHOD'] == 'POST')
{
$kode = $_POST['kode'];
$nama = $_POST['nama'];
$url = $_POST['url'];
$pemilik = $_POST['pemilik'];
$query = "UPDATE webs SET kode = '$kode',nama = '$nama', url = '$url', pemilik = '$pemilik'
WHERE id='$id'";
$exeQuery = mysqli_query($konek, $query);
echo ($exeQuery) ? json_encode(array('kode' =>1, 'pesan' => 'data berhasil update')) :
json_encode(array('kode' =>2, 'pesan' => 'data gagal diupdate'));
}
else
{
echo json_encode(array('kode' =>101, 'pesan' => 'request tidak valid'));
}
?>