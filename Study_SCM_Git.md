# 介绍 #

# 应用 #
  * Linux 代码管理采用 Git 管理

# 源代码管理网站 #
| GitHub | https://github.com/ |
|:-------|:--------------------|
| Bitbucket | https://bitbucket.org/ |
| Google Code | https://code.google.com/hosting/ |


github:
```
fixed issue NUM #NUM , comment
```

修改历史数据？？
```
git filter-branch -f --env-filter "GIT_AUTHOR_NAME='yourname'; GIT_AUTHOR_EMAIL='youremail@xxx.com'; GIT_COMMITTER_NAME='yourname'; GIT_COMMITTER_EMAIL='youremail@xxx.com';" HEAD
```

修改当前的用户名及邮箱：
```
git config user.name 'User Name'
git config user.email 'xxxx@mail.com'
```

**git 默认中文文件名是 xx%
是因为 对0x80以上的字符进行quote**

只需要
```
git config core.quotepath false
```
core.quotepath设为false的话，就不会对0x80以上的字符进行quote。中文显示正常


### 参考资料 ###