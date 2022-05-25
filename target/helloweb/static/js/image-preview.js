
    let image = '';
    function selectImage(file) {
    if (!file.files || !file.files[0]) {
    return;
}
    const reader = new FileReader();
    reader.onload = function (evt) {
    document.getElementById('preview-image').src = evt.target.result;
    image = evt.target.result;
}
    reader.readAsDataURL(file.files[0]);
}