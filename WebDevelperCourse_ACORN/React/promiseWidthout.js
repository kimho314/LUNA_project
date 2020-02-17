function get(id) {
  console.log("starting get");
  return new Promise(resolve => {
    setTimeout(function() {
      let n = { id: id, title: "hello", writerId: "newlec", hit: 10 };
      resolve(n);
    }, 2000);
  });
}

function printTitle() {
  // 1 체인
  get(1)
    .then(function(notice) {
      return notice.title; // 데이터 구성의 분리
    })
    .then(function(title) {
      console.log(title);
    });
}

// printTitle();

function post(notice) {
  console.log("starting post");
  return new Promise(resolve => {
    setTimeout(function() {
      resolve("post is done");
    }, 3000);
  });
}

async function updateTitle(notice) {
  // 2 순차적 호출
  //let curNotice = get(notice.id);
  //   get(notice.id, function(curNotice) {
  //     curNotice.title = notice.title;
  //     post(curNotice, function(result) {
  //       console.log(curNotice);
  //       console.log(result);
  //     });
  //   });

  let curNotice = await get(notice.id);
  curNotice.title = notice.title;
  let result = await post(curNotice);
  console.log(curNotice);
  console.log(result);
}

// let data = { id: 1, title: "이걸로 바꿔줘~" };
// console.log(data);
// updateTitle(data);

function printAll() {
  // 3 병렬호출
  //   let n1 = await get(1);
  //   let n2 = await get(2);

  Promise.all([get(1), get(2)]).then(function(values) {
    console.log(values[0], values[1]);
  });
}

printAll();
