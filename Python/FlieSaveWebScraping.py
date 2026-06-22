import requests
from bs4 import BeautifulSoup

# ==========================================
# 실습 1. 파일 저장 함수 정의 (예외 처리 반영)
# ==========================================
def save_file(filename, text_data):
    file = None
    try:
        # 쓰기 모드(W), 인코딩 UTF-8 설정으로 파일 열기
        file = open(filename, "w", encoding="utf-8")
        
        if text_data:
            file.write(text_data)
            print(f"성공: [{filename}] 파일에 데이터가 기록되었습니다.")
        else:
            file.write("텍스트를 찾을 수 없습니다.")
            print("경고: 추출된 텍스트가 없어 빈 내용이 처리되었습니다.")
            
    except Exception as e:
        print(f"파일 처리 중 오류가 발생했습니다: {e}")
        
    finally:
        # 파일 객체가 열려 있다면 닫아서 시스템 자원 해제
        if file and not file.closed:
            file.close()
            print("시스템 자원이 안전하게 해제되었습니다.")


# ==========================================
# 실습 2. 구글 메인 페이지 웹 스크래핑 수행
# ==========================================
# 1. 대상 URL 정의 및 페이지 요청
url = "https://www.google.com"
response = requests.get(url)

# 2. BeautifulSoup을 이용한 HTML 소스 코드 파싱
soup = BeautifulSoup(response.text, "html.parser")

# 3. 개발자 도구 분석 결과인 태그명('input')과 속성('name':'btnI')으로 요소 탐색
# ※ 강의 스크립트 상 오타(btnl)를 실제 구글 소스코드 표준 속성명인 'btnI'로 보정하여 반영
button_element = soup.find("input", {"name": "btnI"})

# 4. 데이터 추출 및 조건문 처리
if button_element:
    # 버튼 요소 내부의 value 속성값(I'm Feeling Lucky) 추출
    button_text = button_element.get("value")
    print(f"웹 스크래핑 성공 추출 문자열: {button_text}")
    
    # 5. 파일 저장 함수 호출을 통한 로컬 파일 기록
    save_file("google_button.txt", button_text)
else:
    print("구글 메인 페이지에서 해당 버튼 요소를 찾지 못했습니다.")
