var request = new XMLHttpRequest();

request.open('GET', 'http://localhost:8080/', true);
request.onload = function () {

  // Begin accessing JSON data here
  var data = JSON.parse(this.response);

  if (request.status >= 200 && request.status < 400) {
    data.forEach(thought => {
      console.log(thought.title);
    });
  } else {
    console.log('error');
  }
}

request.send();