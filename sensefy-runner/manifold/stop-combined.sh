#! /bin/sh
#*******************************************************************************
# Sensefy
#
# Copyright (c) Zaizi Limited, All rights reserved.
# This library is free software; you can redistribute it and/or
# modify it under the terms of the GNU Lesser General Public
# License as published by the Free Software Foundation; either
# version 3.0 of the License, or (at your option) any later version.
#
# This library is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
# Lesser General Public License for more details.
#
# You should have received a copy of the GNU Lesser General Public
# License along with this library.
#*******************************************************************************
if [ -f "${sensefy.basepath}/manifold-run/manifold.pid" ]
then
	echo "[Apache ManifoldCF] Stopping"
	kill -9 `cat ${sensefy.basepath}/manifold-run/manifold.pid`
	rm ${sensefy.basepath}/manifold-run/manifold.pid
fi
exit 0