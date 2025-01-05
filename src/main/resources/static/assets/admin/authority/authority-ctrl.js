app.controller("authority-ctrl", function($scope, $http, $location) {
    $scope.roles = [];
    $scope.admins = [];
      $scope.all = [];
    $scope.authorities = [];

    $scope.initialize = function() {
        //Load all role in database
        $http.get("/rest/roles").then(resp => {
            $scope.roles = resp.data;
        })
        //Load ALL
  $http.get("/rest/accounts").then(resp => {
            $scope.all = resp.data;
        })
        //Load all auth
$http.get("/rest/authorities").then(resp => {
            $scope.authorities = resp.data;
        }).catch(error => {
            $location.path("/unauthorized");
            console.log(error)
        })
        //
        //Load staffs and directors(administrators)
        $http.get("/rest/accounts?admin=true").then(resp => {
            $scope.admins = resp.data;
        })

        //Load authorites of sataff and directors
        $http.get("/rest/authorities?admin=true").then(resp => {
            $scope.authorities = resp.data;
        }).catch(error => {
            $location.path("/unauthorized");
            console.log(error)
        })
    }

    //Them moi authority
    $scope.grant_authority = function(authority) {
        $http.post(`/rest/authorities`, authority).then(resp => {
            $scope.authorities.push(resp.data);
            alert("Granting permission to use successfully!")
        }).catch(error => {
            alert("Permission to use failed!");
            console.log(error);
        })
    }

    //xoa 
    $scope.revoke_authority = function(authority) {
        $http.delete(`/rest/authorities/${authority.id}`).then(resp => {
            var index = $scope.authorities.findIndex(a => a.id == authority.id);
            $scope.authorities.splice(index, 1);
            alert("Successfully revoked the right to use!")
        }).catch(error => {
            alert("Failed to revoke usage rights!")
            console.log(error);
        })
    }

    $scope.authority_of = function(acc, role) {
        if ($scope.authorities) {
            return $scope.authorities.find(ur => ur.account.username == acc.username && ur.role.id == role.id);
        }
    }


    $scope.authority_changed = function(acc, role) {
        var authority = $scope.authority_of(acc, role);
        if (authority) {
            $scope.revoke_authority(authority);
        } else {
            authority = { account: acc, role: role };
            $scope.grant_authority(authority);
        }
    }
    $scope.initialize();
});