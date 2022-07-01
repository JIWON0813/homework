# homework

과제 제출

#기술 스택
JAVA 11.0.15
Spring Boot 2.7.1
JPA
MYSQL 8.0

#실행 방법

MYSQL 쿼리를 실행 후 프로그램 실행

api 호출 (테스트는 피들러로 request 요청 완료)

POST http://localhost:8080/events

header
Content-Type: application/json

Request Body
{
"type": "REVIEW",
"action": "ADD",
"reviewId": "240a0658-dc5f-4878-9381-ebb7b2667772",
"content": "좋아요!",
"attachedPhotoIds": ["e4d1a64e-a531-46de-88d0-ff0ed70c0bb8", "afb0cef2-851d-4a50-bb07-9cc15cbdc332"],
"userId": "3ede0ef2-92b7-4817-a5f3-0c575361f745",
"placeId": "2e4baf1c-5acb-4efb-a1af-eddada31b00f"
}

#추가

log 쌓는 부분들은 구현 하지 않았습니다. 예외의 경우라 예외처리를 두고 log 쌓아 에러 원인 파악하기 위한 로그 위치들을 주석으로 달았습니다.

테스트 요청 값

테스트리스트
ADD
1.콘텐츠만
2.사진까지
3.첫장소
4.두번째장소

MOD
사진 유 -> 무 , 무 -> 유 포인트 변환


DELETE
전체삭제 - 첫장소까지

이력도 잘 쌓이는지 

{
"type": "REVIEW",
"action": "ADD",
"reviewId": "111",
"content": "좋아요!",
"attachedPhotoIds": [],
"userId": "111",
"placeId": "2e4baf1c-5acb-4efb-a1af-eddada31b00f"
}


{
"type": "REVIEW",
"action": "ADD",
"reviewId": "222",
"content": "좋아요!",
"attachedPhotoIds": ["e4d1a64e-a531-46de-88d0-ff0ed70c0bb8", "afb0cef2-851d-4a50-bb07-9cc15cbdc332"],
"userId": "222",
"placeId": "2e4baf1c-5acb-4efb-a1af-eddada31b00f"
}

{
"type": "REVIEW",
"action": "ADD",
"reviewId": "333",
"content": "좋아요!!!",
"attachedPhotoIds": ["e4d1a64e-a531-46de-88d0-ff0ed70c0bb8", "afb0cef2-851d-4a50-bb07-9cc15cbdc332"],
"userId": "333",
"placeId": "333"
}

{
"type": "REVIEW",
"action": "MOD",
"reviewId": "222",
"content": "좋아요!",
"attachedPhotoIds": [],
"userId": "222",
"placeId": "2e4baf1c-5acb-4efb-a1af-eddada31b00f"
}

{
"type": "REVIEW",
"action": "MOD",
"reviewId": "111",
"content": "좋아요!",
"attachedPhotoIds": ["e4d1a64e-a531-46de-88d0-ff0ed70c0bb8"],
"userId": "111",
"placeId": "2e4baf1c-5acb-4efb-a1af-eddada31b00f"
}


{
"type": "REVIEW",
"action": "DELETE",
"reviewId": "111",
"content": "좋아요!",
"attachedPhotoIds": ["e4d1a64e-a531-46de-88d0-ff0ed70c0bb8"],
"userId": "111",
"placeId": "2e4baf1c-5acb-4efb-a1af-eddada31b00f"
}

{
"type": "REVIEW",
"action": "DELETE",
"reviewId": "222",
"content": "좋아요!",
"attachedPhotoIds": [],
"userId": "222",
"placeId": "2e4baf1c-5acb-4efb-a1af-eddada31b00f"
}

{
"type": "REVIEW",
"action": "ADD",
"reviewId": "444",
"content": "좋아요!!!",
"attachedPhotoIds": ["e4d1a64e-a531-46de-88d0-ff0ed70c0bb8", "afb0cef2-851d-4a50-bb07-9cc15cbdc332"],
"userId": "444",
"placeId": "2e4baf1c-5acb-4efb-a1af-eddada31b00f"
}
