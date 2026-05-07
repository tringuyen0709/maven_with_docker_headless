# Bước 1: Chọn Base Image có sẵn Java và Maven
FROM maven:3.8.6-openjdk-11-slim

# Bước 2: Cài đặt Google Chrome lên Image này
RUN apt-get update && apt-get install -y wget gnupg \
    && wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list \
    && apt-get update && apt-get install -y google-chrome-stable \
    && apt-get clean
	
# Bước 3: Cài đặt Firefox
RUN apt-get update && apt-get install -y firefox-esr \
    && apt-get clean

# Bước 4: Tạo thư mục làm việc trong Container
WORKDIR /app

# Bước 5: Copy file pom.xml và tải các dependency trước (để cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Bước 6: Copy toàn bộ code từ Repo (đã pull về máy Linux) vào Image
COPY . .

# Bước 7: Lệnh để chạy test khi Container khởi động
# Ở đây dùng 'mvn test', bạn có thể thay bằng lệnh chạy TestNG tương ứng
CMD ["mvn", "test", "-Dbrowser=chrome", "-Dheadless=true"]