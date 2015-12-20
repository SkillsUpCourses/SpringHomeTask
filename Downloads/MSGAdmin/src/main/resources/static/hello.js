function Hello($scope, $http) {
//    $http.get("http://localhost:8080/createbus").
//        success(function(data) {
//            $scope.createbus = data;
//        });

//    $http({url:"http://localhost:8080/createbus",
//           method : "POST"}).
//        success(function(data) {
//            $scope.createbus = data;
//        });
        
        
//    $scope.update = function() {
//        $http.get('createbus', {params: {sid: $scope.sid, 
//                                        busId: $scope.busId, 
//                                        deparLogin : $scope.deparLogin,
//                                        respPerson : $scope.respPerson,
//                                        email : $scope.email,
//                                        descr : $scope.descr
//                                       }}).
//	        success(function(data) {
//	            $scope.createbus = data;
//	        });
//                
//    }
              
     $scope.update = function() {
         $http({
             url:"http://localhost:8080/createbus",
             method: 'POST',
             data:{params: {sid: $scope.sid, 
                                        busId: $scope.busId, 
                                        deparLogin : $scope.deparLogin,
                                        respPerson : $scope.respPerson,
                                        email : $scope.email,
                                        descr : $scope.descr
                                       }} 
                         
             
         })
                 .success(function(data) {
	            $scope.createbus = data;
	        });
         
         
     }
   
}