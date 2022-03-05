function myFunction(){
	
	var message
	var display=document.getElementById("dsa").value;
	
	if(display=="Toyota"){
		message="Toyota car runs very smooth";
		
	}else if(display=="Honda"){
		message="Honda runs second smooth car";

	}else if(display=="Ford"){
		message="It is an American car";
		
	}else{
		message="Lincoln is a expensive car";
	}
	document.getElementById("asd").innerHTML=message;
}

function myFunction2(){
	
	var mess
	
	var grade=document.getElementById("grade").value;
	
	switch (grade){
		
		case"A+":
		mess="Excellent result";
		break;
		
		case"B+":
		mess="Not bad!";
		break;
		
		case"C":
		mess="Grade C is better than F ";
		break;
		
		case"F":
		mess="Life is not a bed of rose";
		break;
	}
	document.getElementById("avegrade").innerHTML=mess;
		
}

