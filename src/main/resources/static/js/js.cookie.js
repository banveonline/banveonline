$.ajaxSetup({
beforeSend : function(xhr, settings) {
  if (settings.type == 'POST' || settings.type == 'GET' || settings.type == 'PUT'
      || settings.type == 'DELETE') {
    if (!(/^http:.*/.test(settings.url) || /^https:.*/
        .test(settings.url))) {
      // Only send the token to relative URLs i.e. locally.
      xhr.setRequestHeader("JSESSIONID",
          Cookies.get('JSESSIONID'));
    }
  }
}
});