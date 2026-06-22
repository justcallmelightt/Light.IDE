# ==========================================
# 실습 1. 파일 생성 및 닫기 기초 (myfile.txt)
# ==========================================
# 쓰기 모드(w)로 비어있는 텍스트 파일 생성
f = open("myfile.txt", "w", encoding="utf-8")
# 생성된 파일 객체를 즉시 닫아 자원 해제 및 안전성 확보
f.close()
print("실습 1 완료: myfile.txt 빈 파일 생성 및 파일 닫기 성공")
print("-" * 50)


# ==========================================
# 실습 2. 파일 쓰기 및 다양한 데이터 기록 (exam.txt)
# ==========================================
f_write = open("exam.txt", "w", encoding="utf-8")

# 1. write(): 하나의 문자열 기록 (줄바꿈 없음)
f_write.write("12345")
# 2. write(): 줄바꿈 문자(\n)를 포함한 문자열 기록
f_write.write("abcdefg\n")

# 3. writelines(): 리스트 요소를 순서대로 기록
lines_list = ["ABC\n", "DEF\n", "GHI\n"]
f_write.writelines(lines_list)

# 4. writelines(): 튜플 요소를 순서대로 기록
lines_tuple = ["JKL\n", "MNO\n", "PQR\n"]
f_write.writelines(lines_tuple)

f_write.close()
print("실습 2 완료: exam.txt에 문자열, 리스트, 튜플 데이터 기록 완료")
print("-" * 50)


# ==========================================
# 실습 3. 파일 읽기 방식 3가지 실습 (exam.txt)
# ==========================================
print("--- [실습 3-1] read() 함수로 전체 읽기 ---")
f_read1 = open("exam.txt", "r", encoding="utf-8")
data_all = f_read1.read()  # 인자가 없으므로 전체 데이터를 하나의 문자열로 반환
print(data_all, end="")
f_read1.close()

print("\n--- [실습 3-2] readline() 함수와 반복문으로 읽기 ---")
f_read2 = open("exam.txt", "r", encoding="utf-8")
while True:
    line = f_read2.readline()  # 한 줄씩 읽어오기
    if not line:               # 더 이상 읽을 내용이 없으면(빈 문자열/EOF) 반복문 종료
        break
    print(line, end="")        # 파일 자체의 \n이 있으므로 end="" 처리
f_read2.close()

print("\n\n--- [실습 3-3] readlines() 함수로 리스트 반환 받아 읽기 ---")
f_read3 = open("exam.txt", "r", encoding="utf-8")
all_lines = f_read3.readlines()  # 각 줄을 요소로 갖는 리스트 반환
for single_line in all_lines:
    print(single_line, end="")
f_read3.close()
print("\n" + "-" * 50)


# ==========================================
# 실습 4. tell()과 파일 내부 위치 확인 실습
# ==========================================
print("--- [실습 4] tell() 기반 포인터 위치 추적 ---")
f_tell = open("exam.txt", "r", encoding="utf-8")

print(f"파일을 처음 열었을 때 초기 위치: {f_tell.tell()}")  # 초기값 0

# 5개의 문자(1, 2, 3, 4, 5) 읽기
chars = f_tell.read(5)
print(f"읽어온 문자: {chars} | 현재 포인터 위치: {f_tell.tell()}")  # 위치 5로 이동

# 이어서 한 줄을 읽어오기 (\n 지점까지 추출)
next_line = f_tell.readline()
print(f"읽어온 줄: {next_line.strip()} | 현재 포인터 위치: {f_tell.tell()}")

f_tell.close()
print("-" * 50)


# ==========================================
# 실습 5. seek() 함수를 이용한 포인터 강제 이동 실습
# ==========================================
print("--- [실습 5] seek() 기반 위치 점프 및 부분 추출 ---")
f_seek = open("exam.txt", "r", encoding="utf-8")

# 1. 파일 시작점 기준 3바이트 이동 후 10바이트 읽기
f_seek.seek(3)
print(f"시작점 3바이트 이동 후 10바이트 추출: {f_seek.read(10)}")

# 2. 파일 시작점 기준 5바이트 이동 후 10바이트 읽기 (이전 위치 초기화 검증)
f_seek.seek(5)
print(f"시작점 5바이트 이동 후 10바이트 추출: {f_seek.read(10)}")

# 3. 파일 시작점 기준 10바이트 이동 후 10바이트 읽기
f_seek.seek(10)
print(f"시작점 10바이트 이동 후 10바이트 추출: {f_seek.read(10)}")

f_seek.close()
print("-" * 50)
