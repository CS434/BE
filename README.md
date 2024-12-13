@extends('main_menu.master')
@section('content')
    <section>
        <div class="content">
            <div class="content">
                <div class="row">
                    <div class="card">
                        <div class="card-header">
                            <div class="row">
                                <div class="col-lg-6">
                                    <h2 class="mt-3">Quản lý Sách</h2>
                                </div>
                                <div class="col-lg-6 mt-3 text-end">
                                    <button class="btn btn-lg btn-warning" data-bs-toggle="modal"
                                        data-bs-target="#themMoiSach">Thêm Sách Mới</button>
                                </div>
                            </div>
                            {{-- modal --}}
                            <div class="modal fade" id="themMoiSach" tabindex="-1" aria-labelledby="exampleModalLabel"
                                aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            ...
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary"
                                                data-bs-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr class="horizontal dark mt-0 mb-2">
                        <div class="card-body">
                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th class="text-center text-nowrap">#</th>
                                        <th class="text-center text-nowrap">Bìa Sách</th>
                                        <th class="text-center text-nowrap">Tên Sách</th>
                                        <th class="text-center text-nowrap">Slug Sách</th>
                                        <th class="text-center text-nowrap">Giá</th>
                                        <th class="text-center text-nowrap" style="width: 30px;">Số Lượng</th>
                                        <th class="text-center text-nowrap">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="text-center text-nowrap">1</td>
                                        <td class="text-center text-nowrap"><img src="" alt=""></td>
                                        <td class="text-center text-nowrap">Truyện Tranh</td>
                                        <td class="text-center text-nowrap">truyen-tranh</td>
                                        <td class="text-center text-nowrap">150.000 VNĐ</td>
                                        <td class="text-center text-nowrap">
                                            <input type="number" class="form-control text-center" onfocus="focused(this)"
                                                onfocusout="defocused(this)" value="1" style="width: 30px;">
                                        </td>
                                        <td class="text-center text-nowrap">
                                            <button class="btn btn-primary">Chỉnh sửa</button>
                                            <button class="btn btn-danger">Xoá sách</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="text-center text-nowrap">1</td>
                                        <td class="text-center text-nowrap"><img src="" alt=""></td>
                                        <td class="text-center text-nowrap">Truyện Tranh</td>
                                        <td class="text-center text-nowrap">truyen-tranh</td>
                                        <td class="text-center text-nowrap">150.000 VNĐ</td>
                                        <td class="text-center text-nowrap">
                                            <input type="number" class="form-control text-center" onfocus="focused(this)"
                                                onfocusout="defocused(this)" value="1" style="width: 30px;">
                                        </td>
                                        <td class="text-center text-nowrap">
                                            <button class="btn btn-primary">Chỉnh sửa</button>
                                            <button class="btn btn-danger">Xoá sách</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="text-center text-nowrap">1</td>
                                        <td class="text-center text-nowrap"><img src="" alt=""></td>
                                        <td class="text-center text-nowrap">Truyện Tranh</td>
                                        <td class="text-center text-nowrap">truyen-tranh</td>
                                        <td class="text-center text-nowrap">150.000 VNĐ</td>
                                        <td class="text-center text-nowrap">
                                            <input type="number" class="form-control text-center" onfocus="focused(this)"
                                                onfocusout="defocused(this)" value="1" style="width: 30px;">
                                        </td>
                                        <td class="text-center text-nowrap">
                                            <button class="btn btn-primary">Chỉnh sửa</button>
                                            <button class="btn btn-danger">Xoá sách</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="text-center text-nowrap">1</td>
                                        <td class="text-center text-nowrap"><img src="" alt=""></td>
                                        <td class="text-center text-nowrap">Truyện Tranh</td>
                                        <td class="text-center text-nowrap">truyen-tranh</td>
                                        <td class="text-center text-nowrap">150.000 VNĐ</td>
                                        <td class="text-center text-nowrap">
                                            <input type="number" class="form-control text-center"
                                                onfocus="focused(this)" onfocusout="defocused(this)" value="1"
                                                style="width: 30px;">
                                        </td>
                                        <td class="text-center text-nowrap">
                                            <button class="btn btn-primary">Chỉnh sửa</button>
                                            <button class="btn btn-danger">Xoá sách</button>
                                        </td>
                                    </tr>
                                </tbody>
                                <tfoot>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
@endsection
