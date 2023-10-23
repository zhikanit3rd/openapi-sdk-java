package com.liga.api.method.response.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileListResponse {

    /**文件key */
    private String fileKey;

    /**文件名 */
    private String fileName;

    /**文件类型*/
    private String fileType;

    /**上传用户id */
    private Long uploadUserId;

    /**上传用户名称 */
    private String uploadUserName;

    /**上传时间*/
    private Date uploadTime;

    /**原图地址 */
    private String originalUrl;

    /**文件后缀 */
    private String fileSuffix;

    /**文件地址 */
    private String fileDownloadPath;

    /**大小*/
    private Long fileSize;
}
