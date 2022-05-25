function goPage(pno,pSize){
    const iTable = document.getElementById("search-result");
    const num = iTable.rows.length;//表格所有行数(所有记录数)
    console.log(num);
    let totalPage = 0;//总页数
    const pageSize = pSize;//每页显示行数
    //总共分几页
    if(num/pageSize > parseInt(num/pageSize)){
        totalPage=parseInt(num/pageSize)+1;
    }else{
        totalPage=parseInt(num/pageSize);
    }
    const currentPage = pno;//当前页数
    const startRow = (currentPage - 1) * pageSize + 1;//开始显示的行 31
    let endRow = currentPage * pageSize;//结束显示的行  40
    endRow = (endRow > num)? num : endRow;  //40
    console.log(endRow);
    //遍历显示数据实现分页
    for(let i=1; i<(num+1); i++){
        const iRow = iTable.rows[i - 1];
        if(i>=startRow && i<=endRow){
            iRow.style.display = "block";
        }else{
            iRow.style.display = "none";
        }
    }
    let tempStr = "Total records: " + num + "; Total page: " + totalPage + "; ";
    if(currentPage>1){
        tempStr += "<a href=\"#\" onClick=\"goPage("+(1)+","+pSize+")\">[Home]</a>";
        tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage-1)+","+pSize+")\">&#60;Prev&#62;</a>" + currentPage
    }else{
        tempStr += "[Home]";
        tempStr += "&#60;Prev&#62;" + currentPage;
    }
    if(currentPage<totalPage){
        tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage+1)+","+pSize+")\">&#60;Next&#62;</a>";
        tempStr += "<a href=\"#\" onClick=\"goPage("+(totalPage)+","+pSize+")\">[Last]</a>";
    }else{
        tempStr += "&#60;Next&#62;";
        tempStr += "[Last]";
    }
    document.getElementById("flip-button").innerHTML = tempStr;
}