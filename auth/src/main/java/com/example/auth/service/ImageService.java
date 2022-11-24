package com.example.auth.service;

import com.example.auth.dto.ResponseDto;
import com.example.auth.entity.Image;
import com.example.auth.entity.Users;
import com.example.auth.repo.ImageRepo;
import com.example.auth.repo.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepo imageRepo;
    private final UsersRepository usersRepository;

    public ResponseDto uploadImage(MultipartFile file, int userId) throws IOException {
        Optional<Users> optionalUser = usersRepository.findById(userId);
        if (optionalUser.isPresent()) {
            Users users = optionalUser.get();
            Image image1 = new Image(users.getEmail(), file.getContentType(), compressImage(file.getBytes()));

            users.setProfilePicture(image1);
            Users save = usersRepository.save(users);
            image1.setId(save.getProfilePicture().getId());
            imageRepo.save(image1);
            return new ResponseDto(200, "saved", image1.getName());
        } else {
            return ResponseDto.getSuccess(205, "user not found");
        }
    }


    public ResponseEntity<?> downloadImage(int userId) {
//        Users users = usersRepository.findById(userId).get();
//        Image image = imageRepo.findById(users.getProfilePicture().getId()).get();
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(image.getType())).body(decompressImage(image.getImageData()));

        Optional<Users> optionalUser = usersRepository.findById(userId);
        if (optionalUser.isPresent()){
            Users user = optionalUser.get();
            Optional<Image> optionalImage = imageRepo.findById(user.getProfilePicture().getId());
            if (optionalImage.isPresent()){
                Image image = optionalImage.get();
                return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(image.getType())).body(decompressImage(image.getImageData()));
            }else{
                return ResponseEntity.ok(ResponseDto.getSuccess(205, "picture not found"));
            }

        }else{
            return ResponseEntity.ok(ResponseDto.UserNotFound());
        }
    }

    public byte[] decompressImage(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4 * 1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(tmp);
                outputStream.write(tmp, 0, count);
            }
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
    }

    public byte[] compressImage(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4 * 1024];
        while (!deflater.finished()) {
            int size = deflater.deflate(tmp);
            outputStream.write(tmp, 0, size);
        }
        try {
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
    }
}
