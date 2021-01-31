$(document).ready(function () {

  $("#search-form").submit(function (event) {
    event.preventDefault();
    submit();

  });
});

function submit() {

  var search = {};
  search["username"] = $("#username").val();
  //search["email"] = $("#email").val();

  $("#btn-search").prop("disabled", true);

  $.ajax({
    type: "POST",
    contentType: "application/json",
    url: "/api/search",
    data: JSON.stringify(search),
    dataType: 'json',
    cache: false,
    timeout: 600000,
    success: function (data) {

// iski jagah pe message dikha dio
      var json = "<h4>Ajax Response</h4><pre>"
                 + JSON.stringify(data, null, 4) + "</pre>";
      $('#feedback').html(json);

      console.log("SUCCESS : ", data);
      $("#btn-search").prop("disabled", false);

    },
    error: function (e) {

      // iski jagah pe error message dikha dio
      var json = "<h4>Ajax Response</h4><pre>"
                 + e.responseText + "</pre>";
      $('#feedback').html(json);

      console.log("ERROR : ", e);
      $("#btn-search").prop("disabled", false);

    }
  });
}