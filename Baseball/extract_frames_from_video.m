clear, close all

v = VideoReader('D:\references\VIELAB\Baseball\PLAS_database\Camera1\experiment_1.MP4');

for i=1 : v.FrameRate * v.Duration
    video = readFrame(v);    
    imwrite(video, strcat('D:\references\VIELAB\Baseball\PLAS_database\Camera1\experiment_1\',int2str(i),'.bmp'),'bmp');
    %image_data{i} = video;    
end